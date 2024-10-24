package pe.com.cibertec.LP2_EF_PalaciosJhosep.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
@ToString
public class UsuarioEntity {

    @Id
    @Column(name = "correo", nullable = false, length = 60)
    private String correo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "url_imagen")
    private String urlImagen;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public UsuarioEntity(String correo, String nombre, String apellidos, String password, String urlImagen,
			String fechaNacimiento) {
		super();
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.urlImagen = urlImagen;
		this.fechaNacimiento = fechaNacimiento;
	}

	

    
    
}
