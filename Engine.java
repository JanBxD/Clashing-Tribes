import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;

/**
 * @author Jan Becker
 */
public class Engine
{
    Encrypter encrypter = new Encrypter("passwort");
    
    public Engine(String nameA, String pwA, int admin)
    {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Engine - "+nameA;
		cfg.width = 805;
		cfg.height = 594;
		cfg.resizable = false;
		
		new LwjglApplication(new Orthographic(),cfg);
		
        HF hf = new HF(nameA, pwA, admin);
        hf.setVisible(true);
        //System.out.println('\u000C');
    }
    
    public void encryptText(String text)
    {
        try {
            // Encrypt
            String encrypted = encrypter.encrypt(text);
            
            System.out.println(text);
            System.out.println(encrypted);
            System.out.println("--- End of Encrypt ---"+"\n");
        } catch (Exception e) {}
    }
    
    public void decryptText(String text)
    {
        try {
            // Decrypt 
            String decrypted = encrypter.decrypt(text);

            System.out.println(text);
            System.out.println(decrypted);
            System.out.println("--- End of Decrypt ---"+"\n");
        } catch (Exception e) {}
    }
}
