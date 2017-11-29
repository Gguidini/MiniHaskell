package br.unb.cic.tp1.mh.ast

import scala.collection.mutable

trait Valor extends Expressao

abstract class ValorConcreto[T](val valor : T) extends Valor {
  override def avaliar(): Valor = this
}

case class Closure(id : String, corpo : Expressao, ambiente : mutable.HashMap[String, Valor]) extends Valor {
   override def avaliar(): Valor = this
   override def verificaTipo(): Tipo = {
     corpo.verificaTipo()
   }
}
