package cl.seiza.demo.docker.repository;

import cl.seiza.demo.docker.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class GetUserRepositoryImpl implements GetUserRepository {
    
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcCall =
                new SimpleJdbcCall(dataSource)
                        .withProcedureName("GET_USUARIOS")
                        .returningResultSet("rs1", BeanPropertyRowMapper.newInstance(Usuario.class));
    }

    @Override
    public List<Usuario> getUsuarios(String filtroNombre){
        Map<String, Object> salida = simpleJdbcCall.execute(new MapSqlParameterSource("NOMBRE", filtroNombre));
        return (List<Usuario>) salida.get("rs1");
    }
    
}
