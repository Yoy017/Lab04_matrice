# Rapport
>Auteur Changanaqui Yoann & Duruz Florian

## Points clés de l'implémentations
les opérations sont des classes distinctes héritant toutes de la classe abstraite `Operation`, cette dernière a une méthode abstraite `calcul` devant donc être implémentée par toutes classes enfants, Ainsi chaque opération demandée pourra être différente nous permettant d'éviter une suite de condition dans les opérations liées à deux matrices.

## Tests effectués

Le cas données dans la consigne du labo a été reproduit.

A la création d'une matrice :
* Vérifier que les dimensions et modulo ne soit pas négatifs.
* Si les valeurs sont entrées en dur, elles doivent être dans les limites du modulo.

En effectuant des opérations:
* Vérifier que deux modulos différents lancent une exception
* Vérification du résultat si deux matrices sont de tailles différentes