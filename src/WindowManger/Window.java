package WindowManger;
import org.lwjgl.Version;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;


import LogManger.*;

public class Window {

    // The window handle
    private long window;

    public void run() {
        System.out.println("Running LWJGL " + Version.getVersion() + "!");

        // Inlisie the window.
        window = new WindowInit().init();
        window = new WindowLoop().loop(window);

        //Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();

        try {
            glfwSetErrorCallback(null).free();
        } catch (NullPointerException e) {

            new Log().writeLogEvent(this.getClass(), "ErrorCallBack " + e);
        }
    }
}
