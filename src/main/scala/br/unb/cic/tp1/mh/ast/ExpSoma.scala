package br.unb.cic.tp1.mh.ast

case class ExpSoma(lhs : Expressao, rhs : Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.valor + v2.valor)
  }

  override def verificaTipo: Tipo = {
    val t1 = lhs.verificaTipo
    val t2 = rhs.verificaTipo

    if( t1.isInstanceOf[TInt] && t2.isInstanceOf[TInt] ) {
      return TInt()
    }
    return TErro()
  }
}
