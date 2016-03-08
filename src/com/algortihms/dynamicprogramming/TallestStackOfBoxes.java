package com.algortihms.dynamicprogramming;

import java.util.Stack;

class Box {

	int id;
	int width;
	int height;
	int depth;

	public Box(int id, int w, int h, int d) {
		this.id = id;
		this.width = w;
		this.height = h;
		this.depth = d;
	}

	public boolean canBeAbove(Box box) {

		// printBox(this);
		// printBox(box);

		if (this.width < box.width && this.depth < box.depth && this.height < box.height)

		{
			System.out.println(" Box " + this.id + " can be above " + box.id);
			return true;
		}
		System.out.println(" Box " + this.id + " cannot be above " + box.id);
		return false;
	}

	public static void printBox(Box box) {
		System.out.println("Box id ; " + box.id + " | " + box.width + " | " + box.height + " | " + box.depth);
	}

}

public class TallestStackOfBoxes {

	public static Stack<Box> buildStackForBox(Box bottom, Box[] boxes, Stack<Box> stackOfBoxes, int index) {

		if (boxes[index].canBeAbove(bottom)) {

			System.out.println("Adding " + boxes[index].id);
			stackOfBoxes.push(boxes[index]);
		}

		if (index == boxes.length - 1)
			return stackOfBoxes;

		return buildStackForBox(boxes[index], boxes, stackOfBoxes, index + 1);

	}

	public static Stack<Box> getMaxStack(Box[] boxes) {

		int maxStackSize = 0;
		Stack<Box> maxStack = new Stack<Box>();

		for (int i = 0; i < boxes.length; i++) {
			Stack<Box> stack = new Stack<Box>();
			stack.push(boxes[i]);
			Stack<Box> stackMax = buildStackForBox(boxes[i], boxes, stack, 0);

			if (stackMax.size() > maxStackSize) {
				maxStack = stackMax;
				maxStackSize = stackMax.size();
			}
		}

		return maxStack;
	}

	public static void main(String[] args) {

		Box b1 = new Box(1, 5, 10, 15);
		Box b2 = new Box(2, 10, 15, 20);
		Box b3 = new Box(3, 25, 30, 35);

		Box[] boxes = new Box[] { b3, b2, b1 };

		Stack<Box> stack = getMaxStack(boxes);

		System.out.println(" Boxes : " + boxes.length);
		System.out.println("Stack Size: " + stack.size());

		for (int i = 0; i < stack.size(); i++)
			System.out.println(stack.pop().id);

	}

}
