package com.solution.Elasticsearch.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movieid")
	public int movieid;
	
	@Column(name="movietitle")
	public String movietitle;
	
	@Column(name="moviedesc")
	public String moviedesc;
	
	@Column(name="moviereleasedate")
	public String moviereleasedate;
	
	
	@Column(name="movieruntime")
	public int movieruntime;
	
	@Column(name="moviecertificate")
	public int moviecertificate;
	
	@Column(name="movierating")
	public int 	 movierating;
	
	
	public Movie() {
		
	}


	public int getMovieid() {
		return movieid;
	}


	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}


	public String getMovietitle() {
		return movietitle;
	}


	public void setMovietitle(String movietitle) {
		this.movietitle = movietitle;
	}


	public String getMoviedesc() {
		return moviedesc;
	}


	public void setMoviedesc(String moviedesc) {
		this.moviedesc = moviedesc;
	}


	public String getMoviereleasedate() {
		return moviereleasedate;
	}


	public void setMoviereleasedate(String moviereleasedate) {
		this.moviereleasedate = moviereleasedate;
	}


	public int getMovieruntime() {
		return movieruntime;
	}


	public void setMovieruntime(int movieruntime) {
		this.movieruntime = movieruntime;
	}


	public int getMoviecertificate() {
		return moviecertificate;
	}


	public void setMoviecertificate(int moviecertificate) {
		this.moviecertificate = moviecertificate;
	}


	public int getMovierating() {
		return movierating;
	}


	public void setMovierating(int movierating) {
		this.movierating = movierating;
	}


	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", movietitle=" + movietitle + ", moviedesc=" + moviedesc
				+ ", moviereleasedate=" + moviereleasedate + ", movieruntime=" + movieruntime + ", moviecertificate="
				+ moviecertificate + ", movierating=" + movierating + "]";
	}


	

}
