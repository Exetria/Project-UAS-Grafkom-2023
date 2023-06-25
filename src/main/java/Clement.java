import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public class Clement
{
    private final Window window = new Window(1920, 1080, "window");
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    SkyBoxCube skybox;
    ArrayList<Objects> spheres = new ArrayList<>();

    boolean cameraMode = true;
    float movement= 0.1f;

    public static void main(String[] args)
    {
        new Clement().run();
    }

    public void run()
    {
        init();
        loop();
    }

    public void init()
    {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
//        camera.setPosition(0, 40,  -60f);
        camera.setPosition(0, 0f,0f);
//        camera.setRotation((float) Math.toRadians(25f),  (float) Math.toRadians(180f));

        skybox = new SkyBoxCube();

        spheres.add(new Objects
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.98f, 0.83f, 0.64f, 1.0f), new ArrayList<>(),
                        "C:\\Users\\Clement\\Intellij\\Project-Grafkom-2023-UAS\\resources\\objects\\Clement\\badanMobil.obj"
                )
        );

        spheres.add(new Objects
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.5f, 0.52f, 0.53f, 1.0f), new ArrayList<>(),
                        "C:\\Users\\Clement\\Intellij\\Project-Grafkom-2023-UAS\\resources\\objects\\Clement\\banDalamMobil.obj"
                )
        );

        spheres.add(new Objects
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), new ArrayList<>(),
                        "C:\\Users\\Clement\\Intellij\\Project-Grafkom-2023-UAS\\resources\\objects\\Clement\\banMobil.obj"
                )
        );

        spheres.add(new Objects
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), new ArrayList<>(),
                        "C:\\Users\\Clement\\Intellij\\Project-Grafkom-2023-UAS\\resources\\objects\\Clement\\objectWarnaHitam.obj"
                )
        );

        spheres.add(new Objects
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), new ArrayList<>(),
                        "C:\\Users\\Clement\\Intellij\\Project-Grafkom-2023-UAS\\resources\\objects\\Clement\\objectWarnaPutih.obj"
                )
        );

        spheres.add(new Objects
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(1.0f, 0.0f, 0.0f, 1.0f), new ArrayList<>(),
                        "C:\\Users\\Clement\\Intellij\\Project-Grafkom-2023-UAS\\resources\\objects\\Clement\\lampuMerah.obj"
                )
        );

        spheres.add(new Objects
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(1.0f, 0.45f, 0.09f, 1.0f), new ArrayList<>(),
                        "C:\\Users\\Clement\\Intellij\\Project-Grafkom-2023-UAS\\resources\\objects\\Clement\\lampuOrange.obj"
                )
        );

        spheres.add(new Objects
                (
                        Arrays.asList
                                (new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER), new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        new ArrayList<>(),
                        new Vector4f(0.0f, 1.0f, 0.0f, 1.0f), new ArrayList<>(),
                        "C:\\Users\\Clement\\Intellij\\Project-Grafkom-2023-UAS\\resources\\objects\\Clement\\senjataMobil.obj"
                )
        );


    }

    public void input()
    {
        //WASDQE BUAT ROTATE ATAU TRANSLATE CAMERA
        {
            if(cameraMode)
            {
                if(window.isKeyPressed(GLFW_KEY_Q))
                {
                    camera.moveDown(movement);
                }

                if(window.isKeyPressed(GLFW_KEY_E))
                {
                    camera.moveUp(movement);
                }

                if(window.isKeyPressed(GLFW_KEY_W))
                {
                    camera.moveForward(movement);
                }

                if(window.isKeyPressed(GLFW_KEY_S))
                {
                    camera.moveBackwards(movement);
                }

                if(window.isKeyPressed(GLFW_KEY_A))
                {
                    camera.moveLeft(movement);
                }

                if(window.isKeyPressed(GLFW_KEY_D))
                {
                    camera.moveRight(movement);
                }
            }
            else
            {
                if(window.isKeyPressed(GLFW_KEY_Q))
                {
                    camera.moveUp(movement);
                }

                if(window.isKeyPressed(GLFW_KEY_E))
                {
                    camera.moveUp(movement);
                }

                if(window.isKeyPressed(GLFW_KEY_W))
                {
                    camera.moveForward(movement);
                }

                if(window.isKeyPressed(GLFW_KEY_S))
                {
                    camera.moveBackwards(movement);
                }

                if(window.isKeyPressed(GLFW_KEY_A))
                {
                    camera.moveLeft(movement);
                    camera.rotateTowardsPoint(0, -0.01f, spheres.get(0).getCenterPoint().get(0), spheres.get(0).getCenterPoint().get(1), spheres.get(0).getCenterPoint().get(2));
                }

                if(window.isKeyPressed(GLFW_KEY_D))
                {
                    camera.moveRight(movement);
                    camera.rotateTowardsPoint(0, 0.01f, spheres.get(0).getCenterPoint().get(0), spheres.get(0).getCenterPoint().get(1), spheres.get(0).getCenterPoint().get(2));
                }
            }
        }

        //================================================================================

        //ARROWS BUAT ROTATE CAMERA
        {
            if(window.isKeyPressed(GLFW_KEY_UP))
            {
                camera.addRotation(((float) Math.toRadians(-1)), 0);
            }

            if(window.isKeyPressed(GLFW_KEY_DOWN))
            {
                camera.addRotation(((float) Math.toRadians(1)), 0);
            }

            if(window.isKeyPressed(GLFW_KEY_LEFT))
            {
                camera.addRotation(0f, ((float) Math.toRadians(-1)));
            }

            if(window.isKeyPressed(GLFW_KEY_RIGHT))
            {
                camera.addRotation(0f, ((float) Math.toRadians(1)));
            }
        }

        //================================================================================

        //IJKL BUAT TRANSLATE OBJECT
        {
            if(window.isKeyPressed(GLFW_KEY_U))
            {
                for (Objects i: spheres)
                {
                    i.translateObject(0f, 0f, 0.001f);
                }
            }

            if(window.isKeyPressed(GLFW_KEY_O))
            {
                for (Objects i: spheres)
                {
                    i.translateObject(0f, 0f, -0.001f);
                }
            }

            if(window.isKeyPressed(GLFW_KEY_I))
            {
                for (Objects i: spheres)
                {
                    i.translateObject(0f, 0.001f, 0f);
                }
            }

            if(window.isKeyPressed(GLFW_KEY_K))
            {
                for (Objects i: spheres)
                {
                    i.translateObject(0f, -0.001f, 0f);
                }
            }

            if(window.isKeyPressed(GLFW_KEY_J))
            {
                for (Objects i: spheres)
                {
                    i.translateObject(-0.001f, 0f, 0f);
                }
            }

            if(window.isKeyPressed(GLFW_KEY_L))
            {
                for (Objects i: spheres)
                {
                    i.translateObject(0.001f, 0f, 0f);
                }
            }

            if (window.isKeyPressed(GLFW_KEY_E))
            {

            }
        }

        //================================================================================

        if(window.isKeyPressed(GLFW_KEY_F))
        {
            cameraMode = false;
            System.out.println("Alternative Camera Mode!");
        }

        if(window.isKeyPressed(GLFW_KEY_G))
        {
            cameraMode = true;
            System.out.println("Normal Mode");
        }

        if(window.isKeyPressed(GLFW_KEY_LEFT_SHIFT))
        {
            for (Objects i: spheres)
            {
                camera.moveUp(movement);
            }
        }

        if(window.isKeyPressed(GLFW_KEY_LEFT_CONTROL))
        {
            for (Objects i: spheres)
            {
                camera.moveDown(movement);
            }
        }

        if(window.getMouseInput().isLeftButtonPressed())
        {
            Vector2f displayVector = window.getMouseInput().getDisplVec();
            camera.addRotation((float) Math.toRadians(displayVector.x * 0.1f), (float) Math.toRadians(displayVector.y * 0.1f));
        }

        if(window.getMouseInput().getScroll().y != 0)
        {
            projection.setFOV(projection.getFOV() - (window.getMouseInput().getScroll().y * 0.01f));
            window.getMouseInput().setScroll(new Vector2f());
        }
    }

    public void loop()
    {
        while (window.isOpen())
        {
            //Restore State
            window.update();
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GL.createCapabilities();

            //Code
            for (Objects objects : this.spheres)
            {
                //gambar sekalian child
                objects.draw(camera, projection);
            }
            skybox.draw(camera, projection);

            //Poll for window event
            glDisableVertexAttribArray(0);
            glfwPollEvents();

            input();
        }
    }
}