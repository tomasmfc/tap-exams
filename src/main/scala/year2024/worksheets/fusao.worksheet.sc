import year2024.normal.fusao
import year2024.normal.SimpleTypes.Prova
import year2024.normal.SimpleTypes.RecursoHumano

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

val ll1 = List(List(p1, p2), List(p3, p4))
val ll2 = List(List(p5), List(p1, p2), List(p3, p4))
val ll3 = List(List(p6, p5, p1, p2), List(p3, p4))
val ll4 = List(List(p7, p3, p4), List(p6, p5, p1, p2))

assert(fusao(ll1, p5) == ll2)
assert(fusao(ll2, p6) == ll3)
assert(fusao(ll3, p7) == ll4)
