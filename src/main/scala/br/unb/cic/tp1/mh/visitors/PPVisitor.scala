package br.unb.cic.tp1.mh.visitors
import br.unb.cic.tp1.mh.ast._

class PPVisitor extends Visitor {

  val sb = new StringBuilder("")

  override def visitar(exp: ValorInteiro): Unit = {
    sb.append(exp.valor.toString)
  }

  override def visitar(exp: ValorBooleano): Unit = {
    sb.append(exp.valor.toString)
  }

  override def visitar(exp: ExpAritmetica): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    
    (exp) match {
    	case e : ExpSoma => sb += '+'
    	case e : ExpSub => sb += '-'
    	case e : ExpMul => sb += '*'
    	case e : ExpDivInt => sb += '/'
    	case e : ExpAnd => sb += '&'
    	case e : ExpXor => sb += '^'
    	case e : ExpOr => sb += '|'
    	case e : ExpNor => sb.append("~|")
    	case e : ExpAritmetica => sb.append("op")
    }

    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpLet): Unit = {}

  override def visitar(exp: ExpLambda): Unit = { }

  override def visitar(exp: ExpAplicacaoLambda): Unit = { }

  override def visitar(exp: ExpAplicacaoNomeada): Unit = { }

  override def visitar(exp: ExpRef): Unit = { }

  override def visitar(exp: Closure): Unit = { }
}
