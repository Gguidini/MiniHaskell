package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria._

import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException

case class ExpRef(variavel : String) extends Expressao {

  override def avaliar(): Valor = {
    try {
      return Ambiente.consulta(variavel)
    }
    catch {
      case ex: NoSuchElementException => throw VariavelNaoDeclaradaException()
    }
  } 

  override def verificaTipo(): Tipo = {
    Gama.encontrar( variavel ) 
  }

}
