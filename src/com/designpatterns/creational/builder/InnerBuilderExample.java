package com.designpatterns.creational.builder;


 class Pizza {
	  private int size;
	  private boolean cheese;
	  private boolean pepperoni;
	  private boolean bacon;

	  public static class Builder {
	    //required
	    private final int size;

	    //optional
	    private boolean cheese = false;
	    private boolean pepperoni = false;
	    private boolean bacon = false;

	    public Builder(int size) {
	      this.size = size;
	    }

	    public Builder cheese() {
	      cheese = true;
	      return this;
	    }

	    public Builder pepperoni() {
	      pepperoni = true;
	      return this;
	    }

	    public Builder bacon() {
	      bacon = true;
	      return this;
	    }

	    public Pizza build() {
	      return new Pizza(this);
	    }
	  }

	  private Pizza(Builder builder) {
	    size = builder.size;
	    cheese = builder.cheese;
	    pepperoni = builder.pepperoni;
	    bacon = builder.bacon;
	  }
	}

public class InnerBuilderExample {

	public static void main(String[] args) {
		Pizza pizza = new Pizza.Builder(12).cheese().pepperoni().bacon().build();
	}

}
