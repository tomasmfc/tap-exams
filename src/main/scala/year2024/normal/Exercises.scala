package year2024.normal

import SimpleTypes.*
import year2024.normal.SimpleTypes.Intervalo.sobreposicao

def intervaloPossivel(
    lp: List[(Prova, Intervalo)],
    p: Prova,
    i: Intervalo
): Boolean =
  lp.exists(pi => {
    val recursos = pi._1.lr
    !(Intervalo.sobreposicao(pi._2, i) && p.lr.exists(r =>
      recursos.contains(r)
    ))
  })

def fusao(ll: List[List[Prova]], p: Prova): List[List[Prova]] =

  // Adiciono a prova a cada uma das listas à qual ela tem recursos em comum

  ll.foreach(lp => {
    val recursos = lp.flatMap(_.lr)
    println(recursos)
    if (recursos.exists(r => p.lr.contains(r)))
      p :: lp
  })

  // No final, verifico se a prova de input acabou por ser adicionada. Se não foi, crio uma lista com esta prova e adiciono-a à lista de listas

  if (!ll.exists(lp => lp.contains(p)))
    List(p) :: ll
  else
    ll
