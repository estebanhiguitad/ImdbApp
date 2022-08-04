package co.com.esteban.imdbapp.home.models

import co.com.esteban.imdbapp.R

class MovieBuilder {
    private var title: String = "Stranger things"
    private var rate: String = "5.0"
    private var poster: Int = R.drawable.stranger_things_poster
    private var contentDescription: String = "It is a tv show"

    fun withTitle(title: String): MovieBuilder {
        this.title = title
        return  this@MovieBuilder
    }

    fun build(): Movie = Movie(title, rate, poster, contentDescription)
}
