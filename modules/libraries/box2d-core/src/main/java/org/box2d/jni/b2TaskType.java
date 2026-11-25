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

import org.box2d.jni.system.Library;

/**
 * <pre><code>
 * typedef enum b2TaskType
 * {
 *     b2_taskPairs,
 *     b2_taskCollide,
 *     b2_taskTreeRebuild,
 *     b2_taskIslandSplit,
 *     b2_taskSolver,
 *     b2_taskFinalize,
 *     b2_taskContinuous,
 *     b2_taskSensors,
 *     b2_taskTypeCount
 * } b2TaskType;
 * </code></pre>
 *
 * @author wil
 * @version 1.0.0
 * @since 2.3.0
 */
public enum b2TaskType {
    /**
     * Finding pairs of potentially colliding shapes. The broad-phase.
     * <pre><code>
     * b2_taskPairs -&gt; box2d
     * </code></pre>
     */
    b2_taskPairs(
        nb2_taskPairs()
    ),

    /**
     * Computing contact manifolds. The narrow-phase.
     * <pre><code>
     * b2_taskCollide -&gt; box2d
     * </code></pre>
     */
    b2_taskCollide(
        nb2_taskCollide()
    ),

    /**
     * Rebuilding the bounding volume hierarchy. A long running side task.
     * <pre><code>
     * b2_taskTreeRebuild -&gt; box2d
     * </code></pre>
     */
    b2_taskTreeRebuild(
        nb2_taskTreeRebuild()
    ),

    /**
     * Splitting an island in order to let an island sleep.
     * <pre><code>
     * b2_taskIslandSplit -&gt; box2d
     * </code></pre>
     */
    b2_taskIslandSplit(
        nb2_taskIslandSplit()
    ),

    /**
     * Solving constraints.
     * <pre><code>
     * b2_taskSolver -&gt; box2d
     * </code></pre>
     */
    b2_taskSolver(
        nb2_taskSolver()
    ),

    /**
     * Updating body transforms and shape bounding boxes.
     * <pre><code>
     * b2_taskFinalize -&gt; box2d
     * </code></pre>
     */
    b2_taskFinalize(
        nb2_taskFinalize()
    ),

    /**
     * Continuous collision detection.
     * <pre><code>
     * b2_taskContinuous -&gt; box2d
     * </code></pre>
     */
    b2_taskContinuous(
        nb2_taskContinuous()
    ),

    /**
     * Sensor overlaps and events.
     * <pre><code>
     * b2_taskSensors -&gt; box2d
     * </code></pre>
     */
    b2_taskSensors(
        nb2_taskSensors()
    ),

    /**
     * The type count.
     * <pre><code>
     * b2_taskTypeCount -&gt; box2d
     * </code></pre>
     */
    b2_taskTypeCount(
        nb2_taskTypeCount()
    );

    static {
        Library.initialize();
    }

    /**
     * An integer value that identifies the task type natively,
     * that is, it is the native task type.
     */
    private final int b2Type;

    /**
     * Generate a new <code>b2TaskType</code>.
     * @param b2Type type
     */
    private b2TaskType(int b2Type) {
        this.b2Type = b2Type;
    }

    /**
     * Returns the native type.
     * @return int
     */
    public int value() {
        return b2Type;
    }

    /**
     * Evaluate the native type of a task to return an enumerated object ready to be consumed.
     * @param type type
     * @return task type
     */
    public static b2TaskType valueOf(int type) {
        for (b2TaskType taskType : b2TaskType.values()) {
            if (taskType.value() == type) {
                return taskType;
            }
        }
        throw new UnsupportedOperationException("enum b2TaskType: " + type);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.valueOf(b2Type);
    }

    /* Binding JNI to property 'b2_taskPairs' of structure 'b2TaskType' */
    public static native int nb2_taskPairs();
    /* Binding JNI to property 'b2_taskCollide' of structure 'b2TaskType' */
    public static native int nb2_taskCollide();
    /* Binding JNI to property 'b2_taskTreeRebuild' of structure 'b2TaskType' */
    public static native int nb2_taskTreeRebuild();
    /* Binding JNI to property 'b2_taskIslandSplit' of structure 'b2TaskType' */
    public static native int nb2_taskIslandSplit();
    /* Binding JNI to property 'b2_taskSolver' of structure 'b2TaskType' */
    public static native int nb2_taskSolver();
    /* Binding JNI to property 'b2_taskFinalize' of structure 'b2TaskType' */
    public static native int nb2_taskFinalize();
    /* Binding JNI to property 'b2_taskContinuous' of structure 'b2TaskType' */
    public static native int nb2_taskContinuous();
    /* Binding JNI to property 'b2_taskSensors' of structure 'b2TaskType' */
    public static native int nb2_taskSensors();
    /* Binding JNI to property 'b2_taskTypeCount' of structure 'b2TaskType' */
    public static native int nb2_taskTypeCount();
}
