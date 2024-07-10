import year2024.normal.conjuntos
import year2024.normal.SimpleTypes.RecursoHumano
import year2024.normal.SimpleTypes.Prova

val r1 = RecursoHumano("R1", List.empty)
val r2 = RecursoHumano("R2", List.empty)
val r3 = RecursoHumano("R3", List.empty)
val r5 = RecursoHumano("R5", List.empty)
val r6 = RecursoHumano("R6", List.empty)
val r7 = RecursoHumano("R7", List.empty)
val r9 = RecursoHumano("R9", List.empty)
val r10 = RecursoHumano("R10", List.empty)
val r11 = RecursoHumano("R11", List.empty)

val p1 = Prova("P1", List(r1, r2))
val p2 = Prova("P2", List(r2, r3))
val p3 = Prova("P3", List(r5, r7))
val p4 = Prova("P4", List(r6, r7))
val p5 = Prova("P5", List(r9, r10))
val p6 = Prova("P6", List(r1, r9, r11))
val p7 = Prova("P7", List(r5))

val lp1 = List(p1, p2)
val ll1 = List(List(p2, p1))
val lp2 = List(p1, p2, p3, p4)
val ll2 = List(List(p4, p3), List(p2, p1))
val lp3 = List(p1, p2, p3, p4, p5, p6, p7)
val ll3 = List(List(p7, p4, p3), List(p6, p5, p2, p1))

assert(conjuntos(lp1) == ll1)
assert(conjuntos(lp2) == ll2)
assert(conjuntos(lp3) == ll3)
