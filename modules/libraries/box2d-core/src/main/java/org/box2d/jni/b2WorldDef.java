/*
BSD 3-Clause License

Copyright (c) 2026, Night Rider

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2WorldDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2WorldDef
 * {
 *     b2Vec2 gravity;
 *     float restitutionThreshold;
 *     float hitEventThreshold;
 *     float contactHertz;
 *     float contactDampingRatio;
 *     float contactSpeed;
 *     float maximumLinearSpeed;
 *     b2FrictionCallback* frictionCallback;
 *     b2RestitutionCallback* restitutionCallback;
 *     bool enableSleep;
 *     bool enableContinuous;
 *     bool enableContactSoftening;
 *     int workerCount;
 *     b2EnqueueTaskCallback* enqueueTask;
 *     b2FinishTaskCallback* finishTask;
 *     void* userTaskContext;
 *     void* userData;
 *     const char* recordingPath;
 *     b2Capacity capacity;
 *     int internalValue;
 * } b2WorldDef;
 * </code></pre>
 * 
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2WorldDef extends Struct<b2WorldDef> implements ConstB2WorldDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            GRAVITY,
            RESTITUTION_THRESHOLD,
            HIT_EVENT_THRESHOLD,
            CONTACT_HERTZ,
            CONTACT_DAMPING_RATIO,
            CONTACT_SPEED,
            MAXIMUM_LINEAR_SPEED,
            FRICTION_CALLBACK,
            RESTITUTION_CALLBACK,
            ENABLE_SLEEP,
            ENABLE_CONTINUOUS,
            ENABLE_CONTACT_SOFTENING,
            WORKER_COUNT,
            ENQUEUE_TASK,
            FINISH_TASK,
            USER_TASK_CONTEXT,
            USER_DATA,
            CAPACITY,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(1),
                __member(1),
                __member(1),
                __member(4),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(b2Capacity.SIZEOF, b2Capacity.ALIGNOF),
                __member(4)
        );

        GRAVITY = layout.offsetof(0);
        RESTITUTION_THRESHOLD = layout.offsetof(1);
        HIT_EVENT_THRESHOLD = layout.offsetof(2);
        CONTACT_HERTZ = layout.offsetof(3);
        CONTACT_DAMPING_RATIO = layout.offsetof(4);
        CONTACT_SPEED = layout.offsetof(5);
        MAXIMUM_LINEAR_SPEED = layout.offsetof(6);

        FRICTION_CALLBACK = layout.offsetof(7);
        RESTITUTION_CALLBACK = layout.offsetof(8);

        ENABLE_SLEEP = layout.offsetof(9);
        ENABLE_CONTINUOUS = layout.offsetof(10);
        ENABLE_CONTACT_SOFTENING = layout.offsetof(11);

        WORKER_COUNT = layout.offsetof(12);

        ENQUEUE_TASK = layout.offsetof(13);
        FINISH_TASK = layout.offsetof(14);
        USER_TASK_CONTEXT = layout.offsetof(15);
        USER_DATA = layout.offsetof(16);

        CAPACITY = layout.offsetof(17);
        INTERNAL_VALUE = layout.offsetof(18);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2WorldDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2WorldDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     */
    protected b2WorldDef(long address, boolean factor) {
        super(address, factor);
    }
    
    /** @return Returns the property {@code gravity} */
    @Override
    public b2Vec2 gravity() { return ngravity(address()); }
    /** @return Returns the property {@code restitutionThreshold} */
    @Override
    public float restitutionThreshold() { return nrestitutionThreshold(address()); }
    /** @return Returns the property {@code hitEventThreshold} */
    @Override
    public float hitEventThreshold() { return nhitEventThreshold(address()); }
    /** @return Returns the property {@code contactHertz} */
    @Override
    public float contactHertz() { return ncontactHertz(address()); }
    /** @return Returns the property {@code contactDampingRatio} */
    @Override
    public float contactDampingRatio() { return ncontactDampingRatio(address()); }
    /** @return Returns the property {@code contactSpeed} */
    @Override
    public float contactSpeed() { return ncontactSpeed(address()); }
    /** @return Returns the property {@code maximumLinearSpeed} */
    @Override
    public float maximumLinearSpeed() { return nmaximumLinearSpeed(address()); }
    /** @return Returns the property {@code frictionCallback} */
    @Override
    public long frictionCallback() { return nfrictionCallback(address()); }
    /** @return Returns the property {@code restitutionCallback} */
    @Override
    public long restitutionCallback() { return nrestitutionCallback(address()); }
    /** @return Returns the property {@code enableSleep} */
    @Override
    public boolean enableSleep() { return nenableSleep(address()); }
    /** @return Returns the property {@code enableContinuous} */
    @Override
    public boolean enableContinuous() { return nenableContinuous(address()); }
    /** @return Returns the property {@code enableContactSoftening} */
    @Override
    public boolean enableContactSoftening() { return nenableContactSoftening(address()); }
    /** @return Returns the property {@code workerCount} */
    @Override
    public int workerCount() { return nworkerCount(address()); }
    /** @return Returns the property {@code enqueueTask} */
    @Override
    public long enqueueTask() { return nenqueueTask(address()); }
    /** @return Returns the property {@code finishTask} */
    @Override
    public long finishTask() { return nfinishTask(address()); }
    /** @return Returns the property {@code userTaskContext} */
    @Override
    public long userTaskContext() { return nuserTaskContext(address()); }
    /** @return Returns the property {@code userData} */
    @Override
    public long userData() { return nuserData(address()); }
    /** @return Returns the property {@code capacity} */
    @Override
    public b2Capacity capacity() { return ncapacity(address()); }
    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code gravity}
     * 
     * @param value b2Vec2
     * @return b2WorldDef
     */
    public b2WorldDef gravity(b2Vec2 value) {
        ngravity(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value float
     * @return b2WorldDef
     */
    public b2WorldDef restitutionThreshold(float value) {
        nrestitutionThreshold(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value float
     * @return b2WorldDef
     */
    public b2WorldDef hitEventThreshold(float value) {
        nhitEventThreshold(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value float
     * @return b2WorldDef
     */
    public b2WorldDef contactHertz(float value) {
        ncontactHertz(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value
     * @return b2WorldDef
     */
    public b2WorldDef contactDampingRatio(float value) {
        ncontactDampingRatio(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value float
     * @return b2WorldDef
     */
    public b2WorldDef contactSpeed(float value) {
        ncontactSpeed(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value float
     * @return b2WorldDef
     */
    public b2WorldDef maximumLinearSpeed(float value) {
        nmaximumLinearSpeed(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value b2FrictionCallbackI
     * @return b2WorldDef
     */
    public b2WorldDef frictionCallback(b2FrictionCallbackI value) {
        nfrictionCallback(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value b2RestitutionCallbackI
     * @return b2WorldDef
     */
    public b2WorldDef restitutionCallback(b2RestitutionCallbackI value) {
        nrestitutionCallback(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value boolean
     * @return b2WorldDef
     */
    public b2WorldDef enableSleep(boolean value) {
        nenableSleep(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value boolean
     * @return b2WorldDef
     */
    public b2WorldDef enableContinuous(boolean value) {
        nenableContinuous(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value boolean
     * @return b2WorldDef
     */
    public b2WorldDef enableContactSoftening(boolean value) {
        nenableContactSoftening(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value int
     * @return b2WorldDef
     */
    public b2WorldDef workerCount(int value) {
        nworkerCount(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value b2EnqueueTaskCallbackI
     * @return b2WorldDef
     */
    public b2WorldDef enqueueTask(b2EnqueueTaskCallbackI value) {
        nenqueueTask(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value b2FinishTaskCallbackI
     * @return b2WorldDef
     */
    public b2WorldDef finishTask(b2FinishTaskCallbackI value) {
        nfinishTask(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value long
     * @return b2WorldDef
     */
    public b2WorldDef userTaskContext(long value) {
        nuserTaskContext(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value long
     * @return b2WorldDef
     */
    public b2WorldDef userData(long value) {
        nuserData(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value b2Capacity
     * @return b2WorldDef
     */
    public b2WorldDef capacity(b2Capacity value) {
        ncapacity(address(), value);
        return this;
    }
    /**
     * Set the value of property {@code gravity}
     * 
     * @param value int
     * @return b2WorldDef
     */
    public b2WorldDef internalValue(int value) {
        ninternalValue(address(), value);
        return this;
    }
    
    /*(non-Javadoc)
     */
    @Override
    public int sizeof() {
        return SIZEOF;
    }

    /*(non-Javadoc)
     */
    @Override
    protected b2WorldDef create(long address, Pointer ptr) {
        return ptr == null ? new b2WorldDef(address) : new b2WorldDef(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     *
     * @return b2WorldDef
     */
    private static b2WorldDef factory() {
        return new b2WorldDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2WorldDef
     */
    public static b2WorldDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2WorldDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldDef}.
     *
     * @param alloc Custom memory manager
     * @return b2WorldDef
     */
    public static b2WorldDef alloc(AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, 1, SIZEOF);
        return address == NULL ? null : new b2WorldDef(() -> address);
    }

    /**
     * Reserve memory for the new object {@code b2WorldDef}.
     *
     * @param arean arena
     * @return b2WorldDef
     */
    public static b2WorldDef calloc(ArenaAlloc arean) {
        long ptr = arean.ncalloc(ALIGNOF, 1, SIZEOF);
        return new b2WorldDef(() -> ptr);
    }

    /**
     * Reserve memory for the new object {@code b2WorldDef}.
     *
     * @return b2WorldDef
     */
    public static b2WorldDef malloc() {
        return new b2WorldDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldDef}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        long address = alloc.alloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(address, capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2WorldDef}.
     *
     * @param capacity Number of elements
     * @param arena Arean
     * @return Buffer
     */
    public static Buffer calloc(int capacity, ArenaAlloc arena) {
        long ptr = arena.ncalloc(ALIGNOF, capacity, SIZEOF);
        return new Buffer(ptr, capacity);
    }

    // -----------------------------------

    public static b2Vec2 ngravity(long address)                 { return b2Vec2.createSafe(() -> address + GRAVITY);            }
    public static float nrestitutionThreshold(long address)     { return memGetFloat(address + RESTITUTION_THRESHOLD);          }
    public static float nhitEventThreshold(long address)        { return memGetFloat(address + HIT_EVENT_THRESHOLD);            }
    public static float ncontactHertz(long address)             { return memGetFloat(address + CONTACT_HERTZ);                  }
    public static float ncontactDampingRatio(long address)      { return memGetFloat(address + CONTACT_DAMPING_RATIO);          }
    public static float ncontactSpeed(long address)             { return memGetFloat(address + CONTACT_SPEED);                  }
    public static float nmaximumLinearSpeed(long address)       { return memGetFloat(address + MAXIMUM_LINEAR_SPEED);           }
    public static long nfrictionCallback(long address)          { return memGetAddress(address + FRICTION_CALLBACK);            }
    public static long nrestitutionCallback(long address)       { return memGetAddress(address + RESTITUTION_CALLBACK);         }
    public static boolean nenableSleep(long address)            { return memGetByte(address + ENABLE_SLEEP) != 0;               }
    public static boolean nenableContinuous(long address)       { return memGetByte(address + ENABLE_CONTINUOUS) != 0;          }
    public static boolean nenableContactSoftening(long address) { return memGetByte(address + ENABLE_CONTACT_SOFTENING) != 0;   }
    public static int nworkerCount(long address)                { return memGetInt(address + WORKER_COUNT);                     }
    public static long nenqueueTask(long address)               { return memGetAddress(address + ENQUEUE_TASK);                 }
    public static long nfinishTask(long address)                { return memGetAddress(address + FINISH_TASK);                  }
    public static long nuserTaskContext(long address)           { return memGetAddress(address + USER_TASK_CONTEXT);            }
    public static long nuserData(long address)                  { return memGetAddress(address + USER_DATA);                    }
    public static b2Capacity ncapacity(long address)            { return b2Capacity.createSafe(() -> address + CAPACITY);       }
    public static int ninternalValue(long address)              { return memGetInt(address + INTERNAL_VALUE);                   }

    public static void ngravity(long address, b2Vec2 value)                 { nmemcpy(address + GRAVITY, value.address(), b2Vec2.SIZEOF);         }
    public static void nrestitutionThreshold(long address, float value)     { memPutFloat(address + RESTITUTION_THRESHOLD, value);                      }
    public static void nhitEventThreshold(long address, float value)        { memPutFloat(address + HIT_EVENT_THRESHOLD, value);                        }
    public static void ncontactHertz(long address, float value)             { memPutFloat(address + CONTACT_HERTZ, value);                              }
    public static void ncontactDampingRatio(long address, float value)      { memPutFloat(address + CONTACT_DAMPING_RATIO, value);                      }
    public static void ncontactSpeed(long address, float value)             { memPutFloat(address + CONTACT_SPEED, value);                              }
    public static void nmaximumLinearSpeed(long address, float value)       { memPutFloat(address + MAXIMUM_LINEAR_SPEED, value);                       }
    public static void nfrictionCallback(long address, b2FrictionCallbackI value)       { memPutAddress(address + FRICTION_CALLBACK, value.address());    } 
    public static void nrestitutionCallback(long address, b2RestitutionCallbackI value) { memPutAddress(address + RESTITUTION_CALLBACK, value.address()); }
    public static void nenableSleep(long address, boolean value)            { memPutByte(address + ENABLE_SLEEP, (byte) (value ? 1 : 0));               }
    public static void nenableContinuous(long address, boolean value)       { memPutByte(address + ENABLE_CONTINUOUS, (byte) (value ? 1 : 0));          }
    public static void nenableContactSoftening(long address, boolean value) { memPutByte(address + ENABLE_CONTACT_SOFTENING, (byte) (value ? 1 : 0));   }
    public static void nworkerCount(long address, int value)                { memPutInt(address + WORKER_COUNT, value);                                 }
    public static void nenqueueTask(long address, b2EnqueueTaskCallbackI value) { memPutAddress(address + ENQUEUE_TASK, value.address());         }
    public static void nfinishTask(long address, b2FinishTaskCallbackI value)   { memPutAddress(address + FINISH_TASK, value.address());          }
    public static void nuserTaskContext(long address, long value)           { memPutAddress(address + USER_TASK_CONTEXT, value);                        }
    public static void nuserData(long address, long value)                  { memPutAddress(address + USER_DATA, value);                                }
    public static void ncapacity(long address, b2Capacity value)            { nmemcpy(address + CAPACITY, value.address(), b2Capacity.SIZEOF);    }
    public static void ninternalValue(long address, int value)              { memPutInt(address + INTERNAL_VALUE, value);                               }
    
    // -----------------------------------

    /** An array of {@code b2WorldDef} structs. */
    public static class Buffer extends StructBuffer<b2WorldDef, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2WorldDef ELEMENT_FACTORY = b2WorldDef.factory();

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param remaining int
         */
        public Buffer(long address, int remaining) {
            super(address, remaining);
        }

        /**
         * Create a new buffer.
         *
         * @param address long
         * @param mark int
         * @param position int
         * @param limit int
         * @param capacity int
         */
        public Buffer(long address, int mark, int position, int limit, int capacity) {
            super(address, mark, position, limit, capacity);
        }

        /*(non-Javadoc)
         */
        @Override
        protected b2WorldDef getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Javadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Javadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }
    }
}
