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
package org.box2d.jni.readonly;

/**
 * Interface that is responsible for representing a native object that is a
 * constant of type <code>b2TreeNode</code>. (native type: const b2TreeNode)
 *
 * @author wil
 * @version 2.0.0
 * @since 1.0.0
 */
public interface ConstB2TreeNode extends ConstStruct {

    /**
     * The node bounding box
     *
     * @return ConstB2AABB
     */
    ConstB2AABB aabb();

    /**
     * In 3D this space is used by the AABB z components.
     *
     * @return long
     */
    long padding();

    /**
     * bit 31 : 1 for leaf node
     * bit 30 : 1 for moved flag
     * bits 0-29 : index of the sibling pair node or the proxy id for a leaf
     *
     * @return int
     */
    int flagIndex();

    /**
     * The height of an internal node. A leaf has zero height.
     *
     * @return int
     */
    int height();

    /**
     * The shape index for a leaf. Truncated from proxy user data.
     *
     * @return int
     */
    int shapeIndex();

    /**
     * A template that handles the representation of a constant pointer (buffer)
     * of constant structures such as {@code ConstB2TreeNode}
     *
     * @param <T> The type of object stored in this buffer
     * @param <SELF> The type of this buffer
     */
    interface ConstBuffer<T extends ConstB2TreeNode, SELF extends ConstBuffer<T, SELF>> extends ConstStructBuffer<T, SELF> {
        /* nothing */
    }
}
