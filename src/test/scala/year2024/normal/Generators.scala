package year2024.normal

import org.scalacheck.Properties
import year2024.normal.SimpleTypes.RecursoHumano
import org.scalacheck.Gen
import year2024.normal.SimpleTypes.NomeRecurso
import year2024.normal.SimpleTypes.Prova
import year2024.normal.SimpleTypes.Intervalo

object Generators extends Properties("SimpleTypes"):
  def genRecursos: Gen[List[RecursoHumano]] =
    for {
      n <- Gen.choose(2, 10)
      recursos <- Gen.sequence[List[RecursoHumano], RecursoHumano](
        (2 to n).map(genRecurso(_))
      )
    } yield recursos

  def genRecurso(n: Int): Gen[RecursoHumano] =
    for {
      nome <- NomeRecurso.from(s"RH$n").fold(_ => Gen.fail, Gen.const)
    } yield RecursoHumano(nome, List.empty)

  def genIntervalos(
      lp: List[Prova],
      duracao: Int
  ): Gen[List[(Prova, Intervalo)]] =
    for {
      // Gerar a lista a partir da lista de provas utilizando o genIntervalo para cada prova
      list <- Gen.list
      // Para cada elemento da lista aplicar a função intervalo possível
      // Se o intervalo não for possível, somar 10 ao intervalo atual, tanto no início como no fim
      // Voltar a iterar sobre a lista atualizada
    } yield list

  def genIntervalo(p: Prova, duracao: Int): Gen[(Prova, Intervalo)] =
    for {
      inicio <- Gen.choose(0, 10000)
      fim <- Gen.const(inicio + duracao)
    } yield (p, Intervalo(inicio, fim))
