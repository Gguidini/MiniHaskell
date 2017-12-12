package br.unb.cic.tp1.mh.ast
import br.unb.cic.tp1.mh.visitors.Visitor

// Given that all aritmethic expressions are similar, changing only the operation
// an abstract class was created to save lines of code.
abstract class ExpAritmetica(val lhs : Expressao, val rhs : Expressao) extends Expressao {

  override def avaliar(): Valor

  override def verificaTipo: Tipo = {
    val t1 = lhs.verificaTipo
    val t2 = rhs.verificaTipo

    if(t1 == TInt() && t2 == TInt()) {
      return TInt()
    }
    return TErro()
  }

  override def aceitar(v: Visitor): Unit = {
    v.visitar(this)
  }
}

case class ExpSoma(override val lhs : Expressao, override val rhs : Expressao) extends ExpAritmetica(lhs, rhs) {
    override def avaliar() : Valor = {
      val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
      val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.valor + v2.valor)
    }
}

case class ExpSub(override val lhs : Expressao, override val rhs : Expressao) extends ExpAritmetica(lhs, rhs) {
    override def avaliar() : Valor = {
      val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
      val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.valor - v2.valor)
    }
}

case class ExpMul(override val lhs : Expressao, override val rhs : Expressao) extends ExpAritmetica(lhs, rhs) {
    override def avaliar() : Valor = {
      val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
      val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.valor * v2.valor)
    }
}

case class ExpDivInt(override val lhs : Expressao, override val rhs : Expressao) extends ExpAritmetica(lhs, rhs) {
    override def avaliar() : Valor = {
      val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
      val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.valor / v2.valor)
    }
}

case class ExpXor(override val lhs : Expressao, override val rhs : Expressao) extends ExpAritmetica(lhs, rhs) {
    override def avaliar() : Valor = {
      val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
      val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.valor ^ v2.valor)
    }
}

case class ExpAnd(override val lhs : Expressao, override val rhs : Expressao) extends ExpAritmetica(lhs, rhs) {
    override def avaliar() : Valor = {
      val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
      val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.valor & v2.valor)
    }
}

case class ExpOr(override val lhs : Expressao, override val rhs : Expressao) extends ExpAritmetica(lhs, rhs) {
    override def avaliar() : Valor = {
      val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
      val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.valor | v2.valor)
    }
}

case class ExpNor(override val lhs : Expressao, override val rhs : Expressao) extends ExpAritmetica(lhs, rhs) {
    override def avaliar() : Valor = {
      val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
      val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(~(v1.valor | v2.valor))
    }
}     