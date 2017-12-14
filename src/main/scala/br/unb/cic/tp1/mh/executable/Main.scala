package br.unb.cic.tp1.mh.executable

import br.unb.cic.tp1.mh.ast._
import scala.collection.immutable._
import scala.io.StdIn._

object Main {

	// entry point of program
	def main(args : Array[String]) : Unit = {
		var procede = true
		while(procede){
			// gets input
			val s = readLine("MiniHaskell>")

			// handles commands to program
			if(s.startsWith(":")){

				// exits program
				if(s.substring(1, s.length).equals("exit")){
					procede = false
				}
				// shows help
				else if(s.substring(1, s.length).equals("help")){
					showHelp
				}
				// default fail
				else {
					println("MiniHaskell: " + s.substring(1, s.length) + " command not found")
				}
			}

			// creates tree from expression
			//val tree = new TreeBuilder(s)
			//tree.create
		}

	}

	def showHelp : Unit = {
		println("Currently in debug mode.")
	}
}