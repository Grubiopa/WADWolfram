
import java.util.Date;

@Entity
public class Donaciones(){
	@id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String nickname;
	private long cantidad;
	private long idproyecto;
	private Date fecha;

    protected Donaciones() {
    	
    }
    	
        
        
    public Donaciones(long id, String nickname, long cantidad, long idproyecto, Date fecha) {
        this.id = id;
        this.nickname = nickname;
        this.cantidad = cantidad;
        this.idproyecto = idproyecto;
        this.fecha = fecha;
    }

        
        
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public string getNickname() {
        return nickname;
    }

    public void setNickname(string nickname) {
        this.nickname = nickname;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(long idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

	
}