package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def getEvents(date: String) = Action {
    // Replace this with your logic to retrieve events for the given date
    val events = Seq("Event 1", "Event 2", "Event 3")
    Ok(events.mkString("\n"))
  }

  def createEvent() = Action(parse.json) { request =>
    // Replace this with your logic to create a new event
    val eventName = (request.body \ "name").as[String]
    Created(s"Event $eventName created")
  }
}
