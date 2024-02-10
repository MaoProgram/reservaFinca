package ada.school.reservaFincas.controller;

import ada.school.reservaFincas.service.UsuariosService;
import ada.school.reservaFincas.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ada.school.reservaFincas.lasting.ERole;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UsuariosControllerTest {

    @InjectMocks
    private UsuariosController usuariosController;

    @Mock
    private UsuariosService usuariosService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listar() {

        User user1 = new User(1, "John", "john@example.com", "password", true, ERole.USER);

        when(usuariosService.listar()).thenReturn(Arrays.asList(user1));


        List<User> result = usuariosController.listar();
        assertEquals(1, result.size());
        assertEquals(user1, result.get(0));

        verify(usuariosService, times(1)).listar();
    }

    @Test
    void insertar() {

        User inputUser = new User(1, "John", "john@example.com", "password", true, ERole.USER);
        User expectedUser = new User(1, "John", "john@example.com", "password", true, ERole.USER);
        when(usuariosService.insertar(any(User.class))).thenReturn(expectedUser);

        User result = usuariosController.insertar(inputUser);
        assertEquals(expectedUser, result);


        verify(usuariosService, times(1)).insertar(inputUser);
    }

    @Test
    void actualizar() {

        User inputUser = new User(1, "John", "john@example.com", "password", true, ERole.USER);
        User expectedUser = new User(1, "John", "john@example.com", "password", true, ERole.USER);
        when(usuariosService.actualizar(any(User.class))).thenReturn(expectedUser);

        User result = usuariosController.actualizar(inputUser);
        assertEquals(expectedUser, result);

        verify(usuariosService, times(1)).actualizar(inputUser);
    }

    @Test
    void eliminar() {

        User inputUser = new User(1, "John", "john@example.com", "password", true, ERole.USER);

        usuariosController.eliminar(inputUser);

        verify(usuariosService, times(1)).eliminar(inputUser);
    }
}