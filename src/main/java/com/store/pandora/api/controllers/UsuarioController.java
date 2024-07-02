package com.store.pandora.api.controllers;
import com.store.pandora.api.useCases.usuario.UsuarioService;
import com.store.pandora.api.useCases.usuario.domains.UsuarioCadastroRequestDom;
import com.store.pandora.api.useCases.usuario.domains.UsuarioLoginResponseDom;
import com.store.pandora.api.useCases.usuario.domains.UsuarioRequestDom;
import com.store.pandora.api.useCases.usuario.domains.UsuarioResponseDom;
import com.store.pandora.api.utils.CustomException;
import com.store.pandora.api.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/carregar/{id}")
    public ResponseEntity <?> carregarUsuarioById(@PathVariable Long id) {

        try {
            UsuarioResponseDom response = usuarioService.carregarUsuarioById(id);

            if (response != null){
                return ResponseEntity.ok().body(response);
            }

            return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum usuário cadastrado!"));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @GetMapping("/carregar")
    public ResponseEntity<?> carregarUsuario(){

        try {
            List<UsuarioResponseDom> responseList = usuarioService.carregarUsuario();

            if (responseList.isEmpty()){
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Não existe nenhum usuário cadastrado!"));
            }

            return ResponseEntity.ok().body(responseList);
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDom usuario){

        try{
            UsuarioResponseDom response =  usuarioService.atualizarUsuario(id, usuario);

            if (response == null){
                return ResponseEntity.badRequest().body(ResponseUtil.responseMap("Erro inesperado!"));
            }

            return ResponseEntity.ok(response);
        } catch (CustomException ce){
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody UsuarioRequestDom usuario){
        try {
            UsuarioLoginResponseDom response = usuarioService.loginUsuario(usuario);
            return ResponseEntity.ok().body(response);
        }catch (CustomException ce){
            ce.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastroUsuario(@RequestBody UsuarioCadastroRequestDom usuario){
        try {
            UsuarioLoginResponseDom response = usuarioService.cadastroUsuario(usuario);
            return ResponseEntity.status(201).body(response);
        }catch (CustomException ce){
            ce.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMap(ce.getMessages()));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMap("Erro não mapeado " + ex.getMessage()));
        }
    }
}
