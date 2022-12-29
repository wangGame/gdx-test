/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.badlogic.gdx.physics.bullet.collision;

import com.badlogic.gdx.physics.bullet.linearmath.*;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Matrix4;

public class btGhostObject extends btCollisionObject {
	private long swigCPtr;

	protected btGhostObject (final String className, long cPtr, boolean cMemoryOwn) {
		super(className, CollisionJNI.btGhostObject_SWIGUpcast(cPtr), cMemoryOwn);
		swigCPtr = cPtr;
	}

	/** Construct a new btGhostObject, normally you should not need this constructor it's intended for low-level usage. */
	public btGhostObject (long cPtr, boolean cMemoryOwn) {
		this("btGhostObject", cPtr, cMemoryOwn);
		construct();
	}

	@Override
	protected void reset (long cPtr, boolean cMemoryOwn) {
		if (!destroyed) destroy();
		super.reset(CollisionJNI.btGhostObject_SWIGUpcast(swigCPtr = cPtr), cMemoryOwn);
	}

	public static long getCPtr (btGhostObject obj) {
		return (obj == null) ? 0 : obj.swigCPtr;
	}

	@Override
	protected void finalize () throws Throwable {
		if (!destroyed) destroy();
		super.finalize();
	}

	@Override
	protected synchronized void delete () {
		if (swigCPtr != 0) {
			if (swigCMemOwn) {
				swigCMemOwn = false;
				CollisionJNI.delete_btGhostObject(swigCPtr);
			}
			swigCPtr = 0;
		}
		super.delete();
	}

	public btGhostObject () {
		this(CollisionJNI.new_btGhostObject(), true);
	}

	public void convexSweepTest (btConvexShape castShape, Matrix4 convexFromWorld, Matrix4 convexToWorld,
		ConvexResultCallback resultCallback, float allowedCcdPenetration) {
		CollisionJNI.btGhostObject_convexSweepTest__SWIG_0(swigCPtr, this, btConvexShape.getCPtr(castShape), castShape,
			convexFromWorld, convexToWorld, ConvexResultCallback.getCPtr(resultCallback), resultCallback, allowedCcdPenetration);
	}

	public void convexSweepTest (btConvexShape castShape, Matrix4 convexFromWorld, Matrix4 convexToWorld,
		ConvexResultCallback resultCallback) {
		CollisionJNI.btGhostObject_convexSweepTest__SWIG_1(swigCPtr, this, btConvexShape.getCPtr(castShape), castShape,
			convexFromWorld, convexToWorld, ConvexResultCallback.getCPtr(resultCallback), resultCallback);
	}

	public void rayTest (Vector3 rayFromWorld, Vector3 rayToWorld, RayResultCallback resultCallback) {
		CollisionJNI.btGhostObject_rayTest(swigCPtr, this, rayFromWorld, rayToWorld, RayResultCallback.getCPtr(resultCallback),
			resultCallback);
	}

	public void addOverlappingObjectInternal (btBroadphaseProxy otherProxy, btBroadphaseProxy thisProxy) {
		CollisionJNI.btGhostObject_addOverlappingObjectInternal__SWIG_0(swigCPtr, this, btBroadphaseProxy.getCPtr(otherProxy),
			otherProxy, btBroadphaseProxy.getCPtr(thisProxy), thisProxy);
	}

	public void addOverlappingObjectInternal (btBroadphaseProxy otherProxy) {
		CollisionJNI.btGhostObject_addOverlappingObjectInternal__SWIG_1(swigCPtr, this, btBroadphaseProxy.getCPtr(otherProxy),
			otherProxy);
	}

	public void removeOverlappingObjectInternal (btBroadphaseProxy otherProxy, btDispatcher dispatcher,
		btBroadphaseProxy thisProxy) {
		CollisionJNI.btGhostObject_removeOverlappingObjectInternal__SWIG_0(swigCPtr, this, btBroadphaseProxy.getCPtr(otherProxy),
			otherProxy, btDispatcher.getCPtr(dispatcher), dispatcher, btBroadphaseProxy.getCPtr(thisProxy), thisProxy);
	}

	public void removeOverlappingObjectInternal (btBroadphaseProxy otherProxy, btDispatcher dispatcher) {
		CollisionJNI.btGhostObject_removeOverlappingObjectInternal__SWIG_1(swigCPtr, this, btBroadphaseProxy.getCPtr(otherProxy),
			otherProxy, btDispatcher.getCPtr(dispatcher), dispatcher);
	}

	public int getNumOverlappingObjects () {
		return CollisionJNI.btGhostObject_getNumOverlappingObjects(swigCPtr, this);
	}

	public btCollisionObject getOverlappingObject (int index) {
		return btCollisionObject.getInstance(CollisionJNI.btGhostObject_getOverlappingObject(swigCPtr, this, index), false);
	}

	public btCollisionObject getOverlappingObjectConst (int index) {
		return btCollisionObject.getInstance(CollisionJNI.btGhostObject_getOverlappingObjectConst(swigCPtr, this, index), false);
	}

	public btCollisionObjectArray getOverlappingPairs () {
		return new btCollisionObjectArray(CollisionJNI.btGhostObject_getOverlappingPairs(swigCPtr, this), false);
	}

	public btCollisionObjectArray getOverlappingPairsConst () {
		return new btCollisionObjectArray(CollisionJNI.btGhostObject_getOverlappingPairsConst(swigCPtr, this), true);
	}

	public static btGhostObject upcastConstBtCollisionObject (btCollisionObject colObj) {
		long cPtr = CollisionJNI.btGhostObject_upcastConstBtCollisionObject(btCollisionObject.getCPtr(colObj), colObj);
		return (cPtr == 0) ? null : new btGhostObject(cPtr, false);
	}

	public static btGhostObject upcast (btCollisionObject colObj) {
		long cPtr = CollisionJNI.btGhostObject_upcast(btCollisionObject.getCPtr(colObj), colObj);
		return (cPtr == 0) ? null : new btGhostObject(cPtr, false);
	}

}