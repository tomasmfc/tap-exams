package year2024.normal

object SimpleTypes:

  opaque type NomeRecurso = String
  object NomeRecurso:
    def from(name: String): Result[NomeRecurso] =
      if (name.matches("RH[0-9]+")) Right(name)
      else Left(DomainError.NomeRecursoInvalido)

  opaque type Preferencia = Int

  object Preferencia:
    def from(i: Int): Result[Preferencia] =
      if (i < 0 || i > 5) Left(DomainError.PreferenciaInvalida(i)) else Right(i)
    def zero: Preferencia = 0

  extension (p1: Preferencia)
    // @targetName("lessThanPreferencia")
    def <(p2: Preferencia): Boolean = p1 < p2

    // @targetName("moreThanPreferencia")
    def >(p2: Preferencia): Boolean = p1 > p2

  final case class Intervalo(inicio: Int, fim: Int)

  object Intervalo:
    def sobreposicao(i1: Intervalo, i2: Intervalo): Boolean =
      (i2.inicio > i1.fim) && (i2.fim > i1.inicio)

  final case class Disponibilidade(i: Intervalo, p: Preferencia)
  final case class RecursoHumano(nome: NomeRecurso, Ld: List[Disponibilidade])
  final case class Prova(estudante: String, lr: List[RecursoHumano])
