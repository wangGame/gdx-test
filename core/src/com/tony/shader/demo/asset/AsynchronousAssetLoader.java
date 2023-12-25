package com.tony.shader.demo.asset;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;

public abstract class AsynchronousAssetLoader <T, P extends AssetLoaderParameters<T>> extends AssetLoader<T, P> {
    public AsynchronousAssetLoader (FileHandleResolver resolver) {
        super(resolver);
    }

    /** Loads the non-OpenGL part of the asset and injects any dependencies of the asset into the AssetManager.
     * @param manager
     * @param fileName the name of the asset to load
     * @param file the resolved file to load
     * @param parameter the parameters to use for loading the asset */
    public abstract void loadAsync (AssetManager manager, String fileName, FileHandle file, P parameter);

    /** Called if this task is unloaded before {@link #loadSync(AssetManager, String, FileHandle, AssetLoaderParameters) loadSync}
     * is called. This method may be invoked on any thread, but will not be invoked during or after
     * {@link #loadSync(AssetManager, String, FileHandle, AssetLoaderParameters) loadSync}. This method is not invoked when a task
     * is cancelled because it threw an exception, only when the asset is unloaded before loading is complete.
     * <p>
     * The default implementation does nothing. Subclasses should release any resources acquired in
     * {@link #loadAsync(AssetManager, String, FileHandle, AssetLoaderParameters) loadAsync}, which may or may not have been called
     * before this method, but never during or after this method. Note that
     * {@link #loadAsync(AssetManager, String, FileHandle, AssetLoaderParameters) loadAsync} may still be executing when this
     * method is called and must release any resources it allocated. */
    public void unloadAsync (AssetManager manager, String fileName, FileHandle file, P parameter) {
    }

    /** Loads the OpenGL part of the asset.
     * @param manager
     * @param fileName
     * @param file the resolved file to load
     * @param parameter */
    public abstract T loadSync (AssetManager manager, String fileName, FileHandle file, P parameter);
}
