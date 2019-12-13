package dev.arunkumar.scabbard.plugin.graphviz

import dagger.model.BindingGraph
import javax.lang.model.element.TypeElement

// TODO(arun) Memoize component nodes
fun BindingGraph.subcomponents(parent: TypeElement): Sequence<BindingGraph.ComponentNode> =
  componentNodes().asSequence()
    .filter { node ->
      val componentPath = node.componentPath()
      node.isSubcomponent
          && !componentPath.atRoot()
          && componentPath.parent().currentComponent() == parent
    }