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

  // uses pattern matching to correctly visit all kinds of Aritmetic Expression
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

  override def visitar(exp: ExpLet): Unit = {
    sb.append("let ")
    sb.append(exp.id)  // id
    sb += '='
    exp.expNomeada.aceitar(this)
    sb.append(" in ")
    exp.corpo.aceitar(this)
  }

  override def visitar(exp: ExpLambda): Unit = {
    sb += '('
    sb.append(exp.id)
    sb.append("->")
    exp.corpo.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpAplicacaoLambda): Unit = {
    exp.exp1.aceitar(this)
    sb += '('
    exp.exp2.aceitar(this)
    sb += ')'
  }

  // Dunno, and may change when using multiple
  override def visitar(exp: ExpAplicacaoNomeada): Unit = { }

  override def visitar(exp: ExpRef): Unit = {
    sb.append(exp.variavel)
  }

  // No idea, but necessary to visit ExpAplicacaoNomeada
  override def visitar(exp: Closure): Unit = { }

  override def visitar(exp: ExpCondicional) : Unit = {
    sb += '('
    exp.cond.aceitar(this)

    if(exp.testNature.v){
      sb.append("==")
    }
    else{
      sb.append("!=")
    }
    exp.teste.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpIf) : Unit = { 
    sb.append("if")
    exp.cond.aceitar(this)
    sb += '{'
    sb += '\n'
    exp.corpoIf.aceitar(this)
    sb +='\n'
    sb += '}'
    if(exp.corpoElse != null){
        sb.append("else{")
        sb += '\n'
        exp.corpoElse.aceitar(this)
        sb += '\n'
        sb += '}'
    }

  }
  
}

