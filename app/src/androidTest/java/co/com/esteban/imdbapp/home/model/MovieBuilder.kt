package co.com.esteban.imdbapp.home.model

class MovieBuilder {
    private var title: String = "Stranger things"
    private var rate: String = "5.0"
    private var poster: String = "/q6y0Go1tsGEsmtFryDOJo3dEmqu.jpg"
    private var contentDescription: String = "It is a tv show"

    fun withTitle(title: String): MovieBuilder {
        this.title = title
        return this@MovieBuilder
    }

    fun build(): Movie = Movie(title, rate, poster, contentDescription)
}
