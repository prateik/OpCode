package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;




class RecursiveActionEx extends RecursiveAction{

	
	 private long workLoad = 0;

	    public RecursiveActionEx(long workLoad) {
	        this.workLoad = workLoad;
	    }
	@Override
	protected void compute() {
		 //if work is above threshold, break tasks up into smaller tasks
        if(this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<RecursiveActionEx> subtasks =
                new ArrayList<RecursiveActionEx>();

            subtasks.addAll(createSubtasks());

            for(RecursiveAction subtask : subtasks){
                subtask.fork();
            }

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
        }		
	}
	
	private List<RecursiveActionEx> createSubtasks() {
        List<RecursiveActionEx> subtasks = new ArrayList<RecursiveActionEx>();

        RecursiveActionEx subtask1 = new RecursiveActionEx(this.workLoad-1);
        RecursiveActionEx subtask2 = new RecursiveActionEx(this.workLoad-1);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }

	
	
}
public class ForkJoinRecursiveAction {
	
	public static void main(String... args){
		
		
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(5);
		
		RecursiveActionEx myRecursiveAction = new RecursiveActionEx(24);

		forkJoinPool.invoke(myRecursiveAction);
	}

}
