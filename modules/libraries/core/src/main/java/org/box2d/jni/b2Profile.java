/*
 * Copyright Night Rider. All rights reserved.
 * https://github.com/JNightRider/box2d-jni/blob/master/LICENSE
 */
package org.box2d.jni;

import org.box2d.jni.system.*;

import static org.box2d.jni.libc.LibCStdlib.*;
import static org.box2d.jni.system.Memory.*;

/**
 * <pre><code>
 * typedef struct b2Profile
 * {
 * 	float step;
 * 	float pairs;
 * 	float collide;
 * 	float solve;
 * 	float solverSetup;
 * 	float constraints;
 * 	float prepareConstraints;
 * 	float integrateVelocities;
 * 	float warmStart;
 * 	float solveImpulses;
 * 	float integratePositions;
 * 	float relaxImpulses;
 * 	float applyRestitution;
 * 	float storeImpulses;
 * 	float splitIslands;
 * 	float transforms;
 * 	float sensorHits;
 * 	float jointEvents;
 * 	float hitEvents;
 * 	float refit;
 * 	float bullets;
 * 	float sleepIslands;
 * 	float sensors;
 * } b2Profile;
 * </code></pre>
 *
 * @author wil
 * @since 1.0.0
 * @version 1.0.0
 */
public class b2Profile extends Struct<b2Profile> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    private static final int
            STEP,
            PAIRS,
            COLLIDE,
            SOLVE,
            SOLVER_SETUP,
            CONSTRAINTS,
            PREPARE_CONSTRAINTS,
            INTEGRATE_VELOCITIES,
            WARM_START,
            SOLVE_IMPULSES,
            INTEGRATE_POSITIONS,
            RELAX_IMPULSES,
            APPLY_RESTITUTION,
            STORE_IMPULSES,
            SPLIT_ISLANDS,
            TRANSFORMS,
            SENSOR_HITS,
            JOINT_EVENTS,
            HIT_EVENTS,
            REFIT,
            BULLETS,
            SLEEP_ISLANDS,
            SENSORS;

    static {
        Layout layout = __struct(
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4),
                __member(4)
        );

        STEP = layout.offsetof(0);
        PAIRS = layout.offsetof(1);
        COLLIDE = layout.offsetof(2);
        SOLVE = layout.offsetof(3);
        SOLVER_SETUP = layout.offsetof(4);
        CONSTRAINTS = layout.offsetof(5);
        PREPARE_CONSTRAINTS = layout.offsetof(6);
        INTEGRATE_VELOCITIES = layout.offsetof(7);
        WARM_START = layout.offsetof(8);
        SOLVE_IMPULSES = layout.offsetof(9);
        INTEGRATE_POSITIONS = layout.offsetof(10);
        RELAX_IMPULSES = layout.offsetof(11);
        APPLY_RESTITUTION = layout.offsetof(12);
        STORE_IMPULSES = layout.offsetof(13);
        SPLIT_ISLANDS = layout.offsetof(14);
        TRANSFORMS = layout.offsetof(15);
        SENSOR_HITS = layout.offsetof(16);
        JOINT_EVENTS = layout.offsetof(17);
        HIT_EVENTS = layout.offsetof(18);
        REFIT = layout.offsetof(19);
        BULLETS = layout.offsetof(20);
        SLEEP_ISLANDS = layout.offsetof(21);
        SENSORS = layout.offsetof(22);

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
    }

    /**
     * Generates a reference to the given pointer.
     *
     * @param ptr A reference pointer.
     */
    public b2Profile(Pointer ptr) {
        super(ptr);
    }

    /**
     * Create a new pointer to the object using its memory address.
     *
     * @param address A virtual memory address
     */
    public b2Profile(long address) {
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
    protected b2Profile(long address, boolean factor) {
        super(address, factor);
    }

    /** @return Returns the property {@code step} */
    public float step() { return nstep(address()); }
    /** @return Returns the property {@code pairs} */
    public float pairs() { return npairs(address()); }
    /** @return Returns the property {@code collide} */
    public float collide() { return ncollide(address()); }
    /** @return Returns the property {@code solve} */
    public float solve() { return nsolve(address()); }
    /** @return Returns the property {@code solverSetup} */
    public float solverSetup() { return nsolverSetup(address()); }
    /** @return Returns the property {@code constraints} */
    public float constraints() { return nconstraints(address()); }
    /** @return Returns the property {@code prepareConstraints} */
    public float prepareConstraints() { return nprepareConstraints(address()); }
    /** @return Returns the property {@code integrateVelocities} */
    public float integrateVelocities() { return nintegrateVelocities(address()); }
    /** @return Returns the property {@code warmStart} */
    public float warmStart() { return nwarmStart(address()); }
    /** @return Returns the property {@code solveImpulses} */
    public float solveImpulses() { return nsolveImpulses(address()); }
    /** @return Returns the property {@code integratePositions} */
    public float integratePositions() { return nintegratePositions(address()); }
    /** @return Returns the property {@code relaxImpulses} */
    public float relaxImpulses() { return nrelaxImpulses(address()); }
    /** @return Returns the property {@code applyRestitution} */
    public float applyRestitution() { return napplyRestitution(address()); }
    /** @return Returns the property {@code storeImpulses} */
    public float storeImpulses() { return nstoreImpulses(address()); }
    /** @return Returns the property {@code splitIslands} */
    public float splitIslands() { return nsplitIslands(address()); }
    /** @return Returns the property {@code transforms} */
    public float transforms() { return ntransforms(address()); }
    /** @return Returns the property {@code sensorHits} */
    public float sensorHits() { return nsensorHits(address()); }
    /** @return Returns the property {@code jointEvents} */
    public float jointEvents() { return njointEvents(address()); }
    /** @return Returns the property {@code hitEvents} */
    public float hitEvents() { return nhitEvents(address()); }
    /** @return Returns the property {@code refit} */
    public float refit() { return nrefit(address()); }
    /** @return Returns the property {@code bullets} */
    public float bullets() { return nbullets(address()); }
    /** @return Returns the property {@code sleepIslands} */
    public float sleepIslands() { return nsleepIslands(address()); }
    /** @return Returns the property {@code sensors} */
    public float sensors() { return nsensors(address()); }
    
        /**
     * Set the value of property {@code step}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile step(float value) {
        nstep(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code pairs}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile pairs(float value) {
        npairs(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code collide}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile collide(float value) {
        ncollide(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code solve}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile solve(float value) {
        nsolve(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code solverSetup}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile solverSetup(float value) {
        nsolverSetup(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code constraints}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile constraints(float value) {
        nconstraints(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code prepareConstraints}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile prepareConstraints(float value) {
        nprepareConstraints(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code integrateVelocities}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile integrateVelocities(float value) {
        nintegrateVelocities(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code warmStart}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile warmStart(float value) {
        nwarmStart(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code solveImpulses}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile solveImpulses(float value) {
        nsolveImpulses(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code integratePositions}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile integratePositions(float value) {
        nintegratePositions(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code relaxImpulses}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile relaxImpulses(float value) {
        nrelaxImpulses(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code applyRestitution}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile applyRestitution(float value) {
        napplyRestitution(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code storeImpulses}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile storeImpulses(float value) {
        nstoreImpulses(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code splitIslands}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile splitIslands(float value) {
        nsplitIslands(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code transforms}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile transforms(float value) {
        ntransforms(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code sensorHits}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile sensorHits(float value) {
        nsensorHits(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code jointEvents}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile jointEvents(float value) {
        njointEvents(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code hitEvents}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile hitEvents(float value) {
        nhitEvents(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code refit}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile refit(float value) {
        nrefit(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code bullets}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile bullets(float value) {
        nbullets(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code sleepIslands}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile sleepIslands(float value) {
        nsleepIslands(address(), value);
        return this;
    }

    /**
     * Set the value of property {@code sensors}
     *
     * @param value The value
     * @return b2Profile
     */
    public b2Profile sensors(float value) {
        nsensors(address(), value);
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
    protected b2Profile create(long address, Pointer ptr) {
        return ptr == null ? new b2Profile(address) : new b2Profile(ptr);
    }

    // -----------------------------------

    /**
     * Internal use of the buffer.
     * @return b2Profile
     */
    private static b2Profile factory() {
        return new b2Profile(-1L, true);
    }

    /**
     * Create a reference to a pointer to access its properties.
     *
     * @param ptr A reference pointer.
     * @return b2Profile
     */
    public static b2Profile createSafe(Pointer ptr) {
        if (ptr == null) {
            return null;
        }
        return new b2Profile(ptr);
    }

    /**
     * Reserve memory for the new object {@code b2Profile}.
     *
     * @param alloc Custom memory manager
     * @return b2Profile
     */
    public static b2Profile alloc(AllocFunc alloc) {
        return new b2Profile(alloc.alloc(ALIGNOF, SIZEOF, 1));
    }

    /**
     * Reserve memory for the new object {@code b2Profile}.
     *
     * @return b2Profile
     */
    public static b2Profile malloc() {
        return new b2Profile(nmalloc(SIZEOF));
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Profile}.
     *
     * @param capacity Number of elements
     * @return Buffer
     */
    public static Buffer malloc(int capacity) {
        return new Buffer(nmalloc(capacity * SIZEOF), capacity);
    }

    /**
     * Reserve an amount n of memory for the object {@code b2Profile}.
     *
     * @param capacity Number of elements
     * @param alloc Custom memory manager
     * @return Buffer
     */
    public static Buffer malloc(int capacity, AllocFunc alloc) {
        return new Buffer(alloc.alloc(ALIGNOF, SIZEOF, capacity), capacity);
    }
    
    // -----------------------------------
    
    public static float nstep(long address)                  { return memGetFloat(address + STEP);                 }
    public static float npairs(long address)                 { return memGetFloat(address + PAIRS);                }
    public static float ncollide(long address)               { return memGetFloat(address + COLLIDE);              }
    public static float nsolve(long address)                 { return memGetFloat(address + SOLVE);                }
    public static float nsolverSetup(long address)           { return memGetFloat(address + SOLVER_SETUP);         }
    public static float nconstraints(long address)           { return memGetFloat(address + CONSTRAINTS);          }
    public static float nprepareConstraints(long address)    { return memGetFloat(address + PREPARE_CONSTRAINTS);  }
    public static float nintegrateVelocities(long address)   { return memGetFloat(address + INTEGRATE_VELOCITIES); }
    public static float nwarmStart(long address)             { return memGetFloat(address + WARM_START);           }
    public static float nsolveImpulses(long address)        { return memGetFloat(address + SOLVE_IMPULSES);       }
    public static float nintegratePositions(long address)   { return memGetFloat(address + INTEGRATE_POSITIONS);  }
    public static float nrelaxImpulses(long address)        { return memGetFloat(address + RELAX_IMPULSES);       }
    public static float napplyRestitution(long address)     { return memGetFloat(address + APPLY_RESTITUTION);    }
    public static float nstoreImpulses(long address)        { return memGetFloat(address + STORE_IMPULSES);       }
    public static float nsplitIslands(long address)         { return memGetFloat(address + SPLIT_ISLANDS);        }
    public static float ntransforms(long address)           { return memGetFloat(address + TRANSFORMS);           }
    public static float nsensorHits(long address)           { return memGetFloat(address + SENSOR_HITS);          }
    public static float njointEvents(long address)          { return memGetFloat(address + JOINT_EVENTS);         }
    public static float nhitEvents(long address)            { return memGetFloat(address + HIT_EVENTS);           }
    public static float nrefit(long address)                { return memGetFloat(address + REFIT);                }
    public static float nbullets(long address)              { return memGetFloat(address + BULLETS);              }
    public static float nsleepIslands(long address)         { return memGetFloat(address + SLEEP_ISLANDS);        }
    public static float nsensors(long address)              { return memGetFloat(address + SENSORS);              }

    public static void nstep(long address, float value)                  { memPutFloat(address + STEP, value);                 }
    public static void npairs(long address, float value)                 { memPutFloat(address + PAIRS, value);                }
    public static void ncollide(long address, float value)               { memPutFloat(address + COLLIDE, value);              }
    public static void nsolve(long address, float value)                 { memPutFloat(address + SOLVE, value);                }
    public static void nsolverSetup(long address, float value)           { memPutFloat(address + SOLVER_SETUP, value);         }
    public static void nconstraints(long address, float value)           { memPutFloat(address + CONSTRAINTS, value);          }
    public static void nprepareConstraints(long address, float value)    { memPutFloat(address + PREPARE_CONSTRAINTS, value);  }
    public static void nintegrateVelocities(long address, float value)   { memPutFloat(address + INTEGRATE_VELOCITIES, value); }
    public static void nwarmStart(long address, float value)             { memPutFloat(address + WARM_START, value);           }
    public static void nsolveImpulses(long address, float value)        { memPutFloat(address + SOLVE_IMPULSES, value);       }
    public static void nintegratePositions(long address, float value)   { memPutFloat(address + INTEGRATE_POSITIONS, value);  }
    public static void nrelaxImpulses(long address, float value)        { memPutFloat(address + RELAX_IMPULSES, value);       }
    public static void napplyRestitution(long address, float value)     { memPutFloat(address + APPLY_RESTITUTION, value);    }
    public static void nstoreImpulses(long address, float value)        { memPutFloat(address + STORE_IMPULSES, value);       }
    public static void nsplitIslands(long address, float value)         { memPutFloat(address + SPLIT_ISLANDS, value);        }
    public static void ntransforms(long address, float value)           { memPutFloat(address + TRANSFORMS, value);           }
    public static void nsensorHits(long address, float value)           { memPutFloat(address + SENSOR_HITS, value);          }
    public static void njointEvents(long address, float value)          { memPutFloat(address + JOINT_EVENTS, value);         }
    public static void nhitEvents(long address, float value)            { memPutFloat(address + HIT_EVENTS, value);           }
    public static void nrefit(long address, float value)                { memPutFloat(address + REFIT, value);                }
    public static void nbullets(long address, float value)              { memPutFloat(address + BULLETS, value);              }
    public static void nsleepIslands(long address, float value)         { memPutFloat(address + SLEEP_ISLANDS, value);        }
    public static void nsensors(long address, float value)              { memPutFloat(address + SENSORS, value);              }

    // -----------------------------------

    /** An array of {@code b2Profile} structs. */
    public static class Buffer extends StructBuffer<b2Profile, Buffer> implements JNINative {
        /** An element that provides information about the structure. */
        private static final b2Profile ELEMENT_FACTORY = b2Profile.factory();

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
        protected b2Profile getElementFactory() {
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
