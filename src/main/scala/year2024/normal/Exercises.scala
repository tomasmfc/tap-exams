package year2024.normal

import SimpleTypes.*
import year2024.normal.SimpleTypes.Intervalo.sobreposicao
import scala.annotation.tailrec

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

  val updatedList = ll.map(lp => {
    val recursos = lp.flatMap(_.lr)
    if (recursos.exists(r => p.lr.contains(r)))
      p :: lp
    else lp
  })

  // Criar uma lista só com as listas que contenham a prova P e juntá-las numa só

  val listWithP =
    updatedList.filter(list => list.contains(p)).flatten.distinct

  // Criar uma lista de listas que não contenham a prova P para manter a ordem

  val listWithoutP =
    updatedList.filter(list => !list.contains(p))

  // Juntar as últimas duas listas caso a lista com a prova P não seja vazia

  val finalList =
    if (listWithP.isEmpty) listWithoutP else listWithP :: listWithoutP

  // No final, verifico se a prova de input acabou por ser adicionada. Se não foi, crio uma lista com esta prova e adiciono-a à lista de listas

  if (!finalList.exists(lp => lp.contains(p)))
    List(p) :: finalList
  else
    finalList

def conjuntos(lp: List[Prova]): List[List[Prova]] =
  @tailrec def conjuntos2(
      lpUpdated: List[Prova],
      acc: List[List[Prova]]
  ): List[List[Prova]] =
    if (lpUpdated.isEmpty) acc
    else
      val list = lpUpdated.foldLeft(List.empty[Prova])((acc, elem) => {
        if (acc.isEmpty) elem :: acc
        else
          val resources = acc.flatMap(_.lr).distinct
          if (elem.lr.exists(resource => resources.contains(resource)))
            elem :: acc
          else acc
      })
      conjuntos2(lpUpdated.diff(list), list :: acc)

  conjuntos2(lp, List.empty[List[Prova]])
