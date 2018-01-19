package com.example.inventoryFragmentBD;

import com.example.inventoryFragmentBD.data.db.model.User;
import com.example.inventoryFragmentBD.data.db.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 * 1. El usuario exista en la base de datos (Repository) Para realizar esta prueba se tiene que comparar dos objetos User
 * 2. El usuario no esxiste en la base de datos (Repository)
 * 3. El email no existe en la base de datos (Repository)
 */
public class ExampleUnitTest {

    private ArrayList<User> users;

    @Mock
    private UserRepository userRepository;

    @Before
    public void initialice() {
        userRepository = mock(UserRepository.class);
        users = new ArrayList<>();
        users.add(new User(1,"Migue1","123","Miguel Rodriguez Jimenez", "miguel1@gmail.com",false,false));
        users.add(new User(2,"Migue2","123","Miguel Rodriguez Jimenez", "miguel2@gmail.com",true,false));
        users.add(new User(3,"Migue3","123","Miguel Rodriguez Jimenez", "miguel3@gmail.com",false,true));
        users.add(new User(4,"Migue4","123","Miguel Rodriguez Jimenez", "miguel4@gmail.com",true,true));
    }

    //1. El usuario exista en la base de datos (Repository)
    //Para realizar esta prueba se tiene que comparar dos objetos User

    @Test
    public void isUserExists_isCorrect(){
        //Cuado se llame al metodo isUserExists, devuelva un calor predeterminado.
        when(userRepository.isUserExists(users.get(0))).thenReturn(true);
        assertTrue(userRepository.isUserExists(users.get(0)));
    }

    @Test
    public void getUsers_isCorrect(){
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0),userRepository.getUsers().get(0));
    }

    //4. La contraseña sea correcta (Repository)
    @Test
    public void password_isCorrect() {
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0).getPassword(), userRepository.getUsers().get(0).getPassword());
    }


    @Test
    public void signIn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

    }

    /**
     * Ejemplo de prueba donde vemos el conjuntos de pruebas que podemos realizar
     */
    @Test
    public void testAssertions(){
        //Comparar si don objetos osn iguales
        User user = new User(1,"Migue1","123","Miguel Rodriguez Jimenez", "miguel1@gmail.com",false,false);
        User user2 = null;
        User user3 = user;
        //Un obejto es igual a otro, debe tener el metodo Equals para saber compararlos
        assertEquals(user,users.get(0));
        //Un objeto es nulo
        assertNull(user2);
        //Un objeto no es nulo
        assertNotNull(user);
        //Dos objetos apuntan a la misma referencia
        assertSame(user,user3);
    }

    //2. El usuario no esxiste en la base de datos (Repository)

    //3. El email no existe en la base de datos (Repository)

    @Test
    public void signUn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

    }
}