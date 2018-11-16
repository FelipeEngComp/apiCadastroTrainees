package br.com.sysmap.cadastro.conf;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.sysmap.cadastro.controllers.CandidadoController;
import br.com.sysmap.cadastro.controllers.UsuarioController;
import br.com.sysmap.cadastro.daos.CandidatoDAO;
import br.com.sysmap.cadastro.daos.UsuarioDAO;



@EnableWebMvc
@ComponentScan(basePackageClasses={
		UsuarioDAO.class,
		CandidatoDAO.class,
		CandidadoController.class,
		UsuarioController.class

		
})

public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");		
		
		return resolver;
	}
	
	@Bean
	public ViewResolver contentNegotiationViewResolver(ContentNegotiationManager manager){
	    List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
	    viewResolvers.add(internalResourceViewResolver());
	    viewResolvers.add(new JsonViewResolver());

	    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
	    resolver.setViewResolvers(viewResolvers);
	    resolver.setContentNegotiationManager(manager);
	    return resolver;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
