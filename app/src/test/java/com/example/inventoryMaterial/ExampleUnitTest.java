package com.example.inventoryMaterial;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    //1. El usuario introduce usuario/email

    //2. El usuario introduce una contraseña

    //3. El usuario exista en la base de datos (Repository)

    //4. La contraseña sea correcta
    @Test
    public void signIn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

    }

    //1. El usuario introduce usuario

    //2. El usuario introduce una contraseña

    //5. El usuario introduce un email

    //6. La contraseña tiene al menos 6 caracteres

    //7. El usuario no esxiste en la base de datos (Repository)

    //8. El email no existe en la base de datos (Repository)

    //9. Doble comprobacion de la contraseña
    @Test
    public void signUn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

    }
}