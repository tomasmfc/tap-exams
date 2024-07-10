package year2024.normal

type Result[A] = Either[DomainError, A]

enum DomainError:
  case PreferenciaInvalida(i: Int)
  case NomeRecursoInvalido
