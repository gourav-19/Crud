
package conf;

import com.google.inject.Inject;

import controllers.ApiController;
import controllers.EventControllerImpl;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import ninja.utils.NinjaProperties;

public class Routes implements ApplicationRoutes {

	@Inject
	NinjaProperties ninjaProperties;

	@Override
	public void init(Router router) {

		// puts test data into db:
//        if (!ninjaProperties.isProd()) {
//            router.GET().route("/setup").with(ApplicationController::setup);

		router.GET().route("/getevent").with(EventControllerImpl::eventShow);
		// Api working
		router.GET().route("/api/event.json").with(ApiController::getEventsJson);

		router.POST().route("/newevent").with(EventControllerImpl::newEvent);
		router.POST().route("/eventnew").with(EventControllerImpl::neweventPost);
//		router.PUT().route("/update/event").with(EventControllerImpl::updateEvent);

	
	
	}

	///////////////////////////////////////////////////////////////////////
	// Login / Logout
	///////////////////////////////////////////////////////////////////////
//        router.GET().route("/login").with(LoginLogoutController::login);
//        router.POST().route("/login").with(LoginLogoutController::loginPost);
//        router.GET().route("/logout").with(LoginLogoutController::logout);
//        
//        ///////////////////////////////////////////////////////////////////////
//        // Create new article
//        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/article/new").with(ArticleController::articleNew);
//        router.POST().route("/article/new").with(ArticleController::articleNewPost);
//        router.GET().route("").with(controllerMethod)
//        ///////////////////////////////////////////////////////////////////////
//        // Create new article
//        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/article/{id}").with(ArticleController::articleShow);
//
//        ///////////////////////////////////////////////////////////////////////
//        // Api for management of software
//        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/api/{username}/articles.json").with(ApiController::getArticlesJson);
//        router.GET().route("/api/{username}/article/{id}.json").with(ApiController::getArticleJson);
//        router.GET().route("/api/{username}/articles.xml").with(ApiController::getArticlesXml);
//        router.POST().route("/api/{username}/article.json").with(ApiController::postArticleJson);
//        router.POST().route("/api/{username}/article.xml").with(ApiController::postArticleXml);
// 
//        ///////////////////////////////////////////////////////////////////////
//        // Assets (pictures / javascript)
//        ///////////////////////////////////////////////////////////////////////    
//        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController::serveWebJars);
//        router.GET().route("/assets/{fileName: .*}").with(AssetsController::serveStatic);

	///////////////////////////////////////////////////////////////////////
	// Index / Catchall shows index page
	///////////////////////////////////////////////////////////////////////
//        router.GET().route("/.*").with(ApplicationController::index);
}
