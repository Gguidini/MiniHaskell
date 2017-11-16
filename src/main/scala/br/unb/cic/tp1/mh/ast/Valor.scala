package br.unb.cic.tp1.mh.ast

trait Valor extends Expressao

abstract class ValorConcreto[T](val valor : T) extends Valor {
  override def avaliar(): Valor = this
}

case class Closure(id : String, corpo : Expressao) extends Valor {
   override def avaliar(): Valor = this
}
