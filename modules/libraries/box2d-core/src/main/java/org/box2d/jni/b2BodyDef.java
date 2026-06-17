/*
 * Copyright Night Rider. All rights reserved.
 * https://opensource.org/license/bsd-3-clause
 */
package org.box2d.jni;

import org.box2d.jni.system.*;
import org.box2d.jni.readonly.ConstB2BodyDef;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.libc.LibCString.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2BodyDef
 * {
 *     b2BodyType type;
 *     b2Pos position;
 *     b2Rot rotation;
 *     b2Vec2 linearVelocity;
 *     float angularVelocity;
 *     float linearDamping;
 *     float angularDamping;
 *     float gravityScale;
 *     float sleepThreshold;
 *     const char* name;
 *     void* userData;
 *     b2MotionLocks motionLocks;
 *     bool enableSleep;
 *     bool isAwake;
 *     bool isBullet;
 *     bool isEnabled;
 *     bool allowFastRotation;
 *     bool enableContactRecycling;
 *     int internalValue;
 * } b2BodyDef;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2BodyDef extends Struct<b2BodyDef> implements ConstB2BodyDef {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            TYPE,
            POSITION,
            ROTATION,
            LINEAR_VELOCITY,
            ANGULAR_VELOCITY,
            LINEAR_DAMPING,
            ANGULAR_DAMPING,
            GRAVITY_SCALE,
            SLEEP_THRESHOLD,
            NAME,
            USER_DATA,
            MOTION_LOCKS,
            ENABLE_SLEEP,
            IS_AWAKE,
            IS_BULLET,
            IS_ENABLED,
            ALLOW_FAST_ROTATION,
            ENABLE_CONTACT_RECYCLING,
            INTERNAL_VALUE;

    static {
        Layout layout = __struct(
                __member(4),
                __member(b2Pos.DSIZEOF, b2Pos.DALIGNOF),
                __member(b2Rot.SIZEOF, b2Rot.ALIGNOF),
                __member(b2Vec2.SIZEOF, b2Vec2.ALIGNOF),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(VarType.Uintptrt.sizeof()),
                __member(VarType.Uintptrt.sizeof()),
                __member(b2MotionLocks.SIZEOF, b2MotionLocks.ALIGNOF),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(1),
                __member(4)
        );

        TYPE = layout.offsetof(0);
        POSITION = layout.offsetof(1);
        ROTATION = layout.offsetof(2);
        LINEAR_VELOCITY = layout.offsetof(3);
        ANGULAR_VELOCITY = layout.offsetof(4);
        LINEAR_DAMPING = layout.offsetof(5);
        ANGULAR_DAMPING = layout.offsetof(6);
        GRAVITY_SCALE = layout.offsetof(7);
        SLEEP_THRESHOLD = layout.offsetof(8);
        NAME = layout.offsetof(9);
        USER_DATA = layout.offsetof(10);
        MOTION_LOCKS = layout.offsetof(11);
        ENABLE_SLEEP = layout.offsetof(12);
        IS_AWAKE = layout.offsetof(13);
        IS_BULLET = layout.offsetof(14);
        IS_ENABLED = layout.offsetof(15);
        ALLOW_FAST_ROTATION = layout.offsetof(16);
        ENABLE_CONTACT_RECYCLING = layout.offsetof(17);
        INTERNAL_VALUE = layout.offsetof(18);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2BodyDef(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2BodyDef(long address) {
        super(address);
    }

    /**
     * This structure is for internal buffer use.
     *
     * @param address A virtual memory address
     * @param factor boolean
     *
     * @see Struct#Struct(long, boolean)
     */
    protected b2BodyDef(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code type} */
    @Override
    public b2BodyType type() { return ntype(address()); }
    /** @return Returns the property {@code position} */
    @Override
    public b2Pos position() { return nposition(address()); }
    /** @return Returns the property {@code rotation} */
    @Override
    public b2Rot rotation() { return nrotation(address()); }
    /** @return Returns the property {@code linearVelocity} */
    @Override
    public b2Vec2 linearVelocity() { return nlinearVelocity(address()); }
    /** @return Returns the property {@code angularVelocity} */
    @Override
    public float angularVelocity() { return nangularVelocity(address()); }
    /** @return Returns the property {@code linearDamping} */
    @Override
    public float linearDamping() { return nlinearDamping(address()); }
    /** @return Returns the property {@code angularDamping} */
    @Override
    public float angularDamping() { return nangularDamping(address()); }
    /** @return Returns the property {@code gravityScale} */
    @Override
    public float gravityScale() { return ngravityScale(address()); }
    /** @return Returns the property {@code sleepThreshold} */
    @Override
    public float sleepThreshold() { return nsleepThreshold(address()); }    
    /** @return Returns the property {@code name} */
    @Override
    public long name() { return nname(address()); }
    /** @return Returns the property {@code userData} */
    @Override
    public long userData() { return nuserData(address()); }
    /** @return Returns the property {@code motionLocks} */
    @Override
    public b2MotionLocks motionLocks() { return nmotionLocks(address()); }
    /** @return Returns the property {@code enableSleep} */
    @Override
    public boolean enableSleep() { return nenableSleep(address()); }
    /** @return Returns the property {@code isAwake} */
    @Override
    public boolean isAwake() { return nisAwake(address()); }
    /** @return Returns the property {@code isBullet} */
    @Override
    public boolean isBullet() { return nisBullet(address()); }
    /** @return Returns the property {@code isEnabled} */
    @Override
    public boolean isEnabled() { return nisEnabled(address()); }
    /** @return Returns the property {@code allowFastRotation} */
    @Override
    public boolean allowFastRotation() { return nallowFastRotation(address()); }
    /** @return Returns the property {@code enableContactRecycling} */
    @Override
    public boolean enableContactRecycling() { return nenableContactRecycling(address()); }
    /** @return Returns the property {@code internalValue} */
    @Override
    public int internalValue() { return ninternalValue(address()); }

    /**
     * Set the value of property {@code type}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef type(b2BodyType value) { ntype(address(), value); return this; }
    /**
     * Set the value of property {@code position}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef position(b2Pos value) { nposition(address(), value); return this; }
    /**
     * Set the value of property {@code rotation}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef rotation(b2Rot value) { nrotation(address(), value); return this; }
    /**
     * Set the value of property {@code linearVelocity}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef linearVelocity(b2Vec2 value) { linearVelocity(address(), value); return this; }
    /**
     * Set the value of property {@code angularVelocity}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef angularVelocity(float value) { nangularVelocity(address(), value); return this; }
    /**
     * Set the value of property {@code linearDamping}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef linearDamping(float value) { nlinearDamping(address(), value); return this; }
    /**
     * Set the value of property {@code angularDamping}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef angularDamping(float value) { nangularDamping(address(), value); return this; }
    /**
     * Set the value of property {@code gravityScale}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef gravityScale(float value) { ngravityScale(address(), value); return this; }
    /**
     * Set the value of property {@code sleepThreshold}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef sleepThreshold(float value) { nsleepThreshold(address(), value); return this; }
    /**
     * Set the value of property {@code name}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef name(long value) { nname(address(), value); return this; }
    /**
     * Set the value of property {@code userData}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef userData(long value) { nuserData(address(), value); return this; }
    /**
     * Set the value of property {@code motionLocks}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef motionLocks(b2MotionLocks value) { nmotionLocks(address(), value); return this; }
    /**
     * Set the value of property {@code enableSleep}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef enableSleep(boolean value) { nenableSleep(address(), value); return this; }
    /**
     * Set the value of property {@code isAwake}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef isAwake(boolean value) { nisAwake(address(), value); return this; }
    /**
     * Set the value of property {@code isBullet}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef isBullet(boolean value) { nisBullet(address(), value); return this; }
    /**
     * Set the value of property {@code isEnabled}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef isEnabled(boolean value) { nisEnabled(address(), value); return this; }
    /**
     * Set the value of property {@code allowFastRotation}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef allowFastRotation(boolean value) { nallowFastRotation(address(), value); return this; }
    /**
     * Set the value of property {@code enableContactRecycling}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef enableContactRecycling(boolean value) { nenableContactRecycling(address(), value); return this; }
    /**
     * Set the value of property {@code internalValue}
     *
     * @param value The value
     * @return b2BodyDef
     */
    public b2BodyDef internalValue(int value) { ninternalValue(address(), value); return this; }

    /*(non-Javadoc)
     */
    @Override
    public int sizeof() {
        return SIZEOF;
    }

    /*(non-Javadoc)
     */
    @Override
    protected b2BodyDef create(long address, Pointer ptr) {
        return ptr == null ? new b2BodyDef(address) : new b2BodyDef(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2BodyDef
     */
    private static b2BodyDef factory() {
        return new b2BodyDef(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2BodyDef
     */
    public static b2BodyDef createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2BodyDef(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2BodyDef}.
     *
     * @param alloc Custom memory manager
     * @return b2BodyDef
     */
    public static b2BodyDef alloc(AllocFunc alloc) {
        return new b2BodyDef(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2BodyDef}.
     *
     * @return b2BodyDef
     */
    public static b2BodyDef malloc() {
        return new b2BodyDef(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2BodyDef}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2BodyDef}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer( alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }

    // -----------------------------------

    public static b2BodyType ntype(long address)                { return b2BodyType.valueOf(memGetInt(address + TYPE));        }
    public static b2Pos nposition(long address)                 { return b2Pos.ncreateSafe(() -> address + POSITION);               }
    public static b2Rot nrotation(long address)                 { return b2Rot.createSafe(() -> address + ROTATION);                }
    public static b2Vec2 nlinearVelocity(long address)          { return b2Vec2.createSafe(() -> address + LINEAR_VELOCITY);        }
    public static float nangularVelocity(long address)          { return memGetFloat(address + ANGULAR_VELOCITY);                   }
    public static float nlinearDamping(long address)            { return memGetFloat(address + LINEAR_DAMPING);                     }
    public static float nangularDamping(long address)           { return memGetFloat(address + ANGULAR_DAMPING);                    }
    public static float ngravityScale(long address)             { return memGetFloat(address + GRAVITY_SCALE);                      }
    public static float nsleepThreshold(long address)           { return memGetFloat(address + SLEEP_THRESHOLD);                    }
    public static long nname(long address)                      { return memGetAddress(address + NAME);                             }
    public static long nuserData(long address)                  { return memGetAddress(address + USER_DATA);                        }
    public static b2MotionLocks nmotionLocks(long address)      { return b2MotionLocks.createSafe(() -> address + MOTION_LOCKS);    }
    public static boolean nenableSleep(long address)            { return memGetByte(address + ENABLE_SLEEP) != 0;                   }
    public static boolean nisAwake(long address)                { return memGetByte(address + IS_AWAKE) != 0;                       }
    public static boolean nisBullet(long address)               { return memGetByte(address + IS_BULLET) != 0;                      }
    public static boolean nisEnabled(long address)              { return memGetByte(address + IS_ENABLED) != 0;                     }
    public static boolean nallowFastRotation(long address)      { return memGetByte(address + ALLOW_FAST_ROTATION) != 0;            }
    public static boolean nenableContactRecycling(long address) { return memGetByte(address + ENABLE_CONTACT_RECYCLING) != 0;       }
    public static int ninternalValue(long address)              { return memGetInt(address + INTERNAL_VALUE);                       }

    public static void ntype(long address, b2BodyType value)                { memPutInt(address + TYPE, value.value());                               }
    public static void nposition(long address, b2Pos value)                 { nmemcpy(address + POSITION, value.address(), b2Pos.DSIZEOF);            }
    public static void nrotation(long address, b2Rot value)                 { nmemcpy(address + ROTATION, value.address(), b2Rot.SIZEOF);             }
    public static void linearVelocity(long address, b2Vec2 value)           { nmemcpy(address + LINEAR_VELOCITY, value.address(), b2Vec2.SIZEOF);     }
    public static void nangularVelocity(long address, float value)          { memPutFloat(address + ANGULAR_VELOCITY, value);                               }
    public static void nlinearDamping(long address, float value)            { memPutFloat(address + LINEAR_DAMPING, value);                                 }
    public static void nangularDamping(long address, float value)           { memPutFloat(address + ANGULAR_DAMPING, value);                                }
    public static void ngravityScale(long address, float value)             { memPutFloat(address + GRAVITY_SCALE, value);                                  }
    public static void nsleepThreshold(long address, float value)           { memPutFloat(address + SLEEP_THRESHOLD, value);                                }
    public static void nname(long address, long value)                      { memPutAddress(address + NAME, value);                                         }
    public static void nuserData(long address, long value)                  { memPutAddress(address + USER_DATA, value);                                    }
    public static void nmotionLocks(long address, b2MotionLocks value)      { nmemcpy(address + MOTION_LOCKS, value.address(), b2MotionLocks.SIZEOF); }
    public static void nenableSleep(long address, boolean value)            { memPutByte(address + ENABLE_SLEEP, (byte) (value ? 1 : 0));                   }
    public static void nisAwake(long address, boolean value)                { memPutByte(address + IS_AWAKE, (byte) (value ? 1 : 0));                       }
    public static void nisBullet(long address, boolean value)               { memPutByte(address + IS_BULLET, (byte) (value ? 1 : 0));                      }
    public static void nisEnabled(long address, boolean value)              { memPutByte(address + IS_ENABLED, (byte) (value ? 1 : 0));                     }
    public static void nallowFastRotation(long address, boolean value)      { memPutByte(address + ALLOW_FAST_ROTATION, (byte) (value ? 1 : 0));            }
    public static void nenableContactRecycling(long address, boolean value) { memPutByte(address + ENABLE_CONTACT_RECYCLING, (byte) (value ? 1 : 0));       }
    public static void ninternalValue(long address, int value)              { memPutInt(address + INTERNAL_VALUE, value);                                   }

    // -----------------------------------

    /** An array of {@code b2BodyDef} structs. */
    public static class Buffer extends StructBuffer<b2BodyDef, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2BodyDef ELEMENT_FACTORY = b2BodyDef.factory();

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

        /*(non-Jabadoc)
         */
        @Override
        protected b2BodyDef getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer self() {
            return this;
        }

        /*(non-Jabadoc)
         */
        @Override
        protected Buffer create(long address, int mark, int position, int limit, int capacity) {
            return new Buffer(address, mark, position, limit, capacity);
        }  
    }
}