package org.box2d.jni;

import org.box2d.jni.system.Debug;
import org.box2d.jni.system.Memory;
import org.box2d.jni.system.VarType;


public class Main {

    public static void main(String[] args) {
        b2Vec2 vec2 = b2Vec2.malloc();
        
        vec2.x(2).y(7);
        
        Debug.apiPrint("x: %f, y: %f".formatted(vec2.x(), vec2.y()));
        Debug.apiPrint("Sizeof: b2Vec2 " + vec2.sizeof());
        Debug.apiPrint("CSizeof: b2Vec2 " + Memory.memSizeOf(vec2.address()));
        
        b2Vec2 ref = new b2Vec2(() -> vec2.address());        
        ref.close();
        vec2.close();
        
        
        b2Vec2.Buffer buffer = b2Vec2.malloc(3);
        buffer.put(b2Vec2.malloc().x(1).y(0));
        buffer.put(b2Vec2.malloc().x(3).y(4));
        buffer.put(b2Vec2.malloc().x(4).y(8));
        buffer.flip();
        
        
        for (int i = 0; i < buffer.remaining(); i++) {
            b2Vec2 v = buffer.get(i);
            Debug.apiPrint("[" + i + "] : x=" + v.x() + ", y=" + v.y());
        }
    }
}
