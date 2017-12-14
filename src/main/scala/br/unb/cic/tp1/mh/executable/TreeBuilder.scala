/*package br.unb.cic.tp1.mh.executable
package br.unb.cic.tp1.mh.ast


// immutable is for stringOps. mutable is for stack
import scala.collection.immutable._ 
import scala.io.StdIn._
import scala.collection.mutable

class TreeBuilder(val s : string) {

	// private val stringBreaker = new mutable.Stack[TreeNode]()

	// private val expBuilder = new mutable.Stack[TreeNodes]()

	// breaks string into tree and returns expression to be computed. Needs refactoring. Method too extensive
	def create(string : String) : TreeNode = {
		if(string == null){
			return null
		}
		// first node ?
		val s = string.trim 	// removes spaces... maybe not a good idea
		
			if(s.startsWith("let")){
				// expression of kind "let <var>=<expression> in <expression>"

				val idxIn = s.indexOfSlice("in")
				val idxEq = s.indexOf('=')
				val id = s.substring(3, idxEq)	// gets ID name
				val expNomeada = s.substring(idxEq+1, idxIn)	// gets EXp expNomeada
				val corpo = s.substring(idxIn+1, s.length)	// gets body

				// breakes down the rest of the expressions
				val children = Array(this.create(id), this.create(expNomeada), this.create(corpo))

				return new TreeNode("let", children)
			}
			// needs to be improved, since it could mistainkingly analyse a lambda application for a lambda expression.
			// currently forcing lambda applications to use [].
			else if(s.containsSlice("->") && !s.contains('[')) {
				// lambda expression of kind "(<var>:<type>-><body>)"

				val idxColon = s.indexOf(':')
				val idxArrow = s.indexOfSlice("->")
				val variable = s.substring(1, idxColon)
				val varType = s.substring(idxColon+1, idxArrow)
				val corpo = s.substring(idxArrow+1, s.length-1)

				// breaks down rest of expressions
				val children = Array(this.create(variable), this.create(varType), this.create(corpo))

				return new TreeNode("ExpLambda", children)
			}
			else if(s.containsSlice("->") && s.contains('[')){
				// lambda application of kind "(<var>:<type>-><body>)[<expression>]"

				val idxColon = s.indexOf(':')
				val idxArrow = s.indexOfSlice("->")
				val idxBracket = s.indexOf('[')
				val variable = s.substring(1, idxColon)
				val varType = s.substring(idxColon+1, idxArrow)
				val corpo = s.substring(idxArrow+1, idxBracket)
				val parametro = s.substring(idxBracket+1, s.length-1)

				// breaks down rest of expressions
				val children = Array(this.create(variable), this.create(varType), this.create(corpo), this.create(parametro))

				return new TreeNode("ExpAppLambda", children)
			}
			else if(s.containsSlice("if")){
				// if expression of kind "if(<condition>==<test>){<expression>}else{<expression>}". Else may not be present

				val idxDoubleEq = s.indexOfSlice("==")
			}
		}


	// creates the final expression from string
	def buildExpression(root : TreeNode) : Expressao
}


class TreeNode(val kind : String, val children : Array[TreeNode] = null) {

}
*/