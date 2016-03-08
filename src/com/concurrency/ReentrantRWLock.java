package com.concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;


/*Release all locks in finally block. This is rule 1 for a reason.
Beware of thread starvation! The fair setting in ReentrantLocks may be useful if you have many readers and occasional writers that you don’t want waiting forever. It’s possible a writer could wait a very long time (maybe forever) if there are constantly read locks held by other threads.
Use synchronized where possible. You will avoid bugs and keep your code cleaner.
Use tryLock() if you don’t want a thread waiting indefinitely to acquire a lock – this is similar to wait lock timeouts that databases have.

*/
public class ReentrantRWLock {
	
	
	private int calculatedValue;
    private int value;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void calculate(int value) {
        lock.writeLock().lock();
        try {
            this.value = value;
            this.calculatedValue = value+10;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getCalculatedValue() {
        lock.readLock().lock();
        try {
            return calculatedValue;
        } finally {
            lock.readLock().unlock();
        }
    }

    public int getValue() {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }
	
}
