package security.jwt;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint{
	private static final Logger logger = (Logger) LoggerFactory.getLogger(AuthEntryPointJwt.class);
	
	public void commence(HttpServletRequest request, HttpServletResponse response, 
			AuthenticationException authException) throws IOException, ServletException{
		logger.error("Unauthorized error: {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}
	

}
