package dev.arunkumar.scabbard.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.arunkumar.scabbard.App
import dev.arunkumar.scabbard.debug.*
import dev.arunkumar.scabbard.home.HomeActivity
import dev.arunkumar.scabbard.home.simple.SimpleSubcomponent
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    ProvisionModule::class,
    NamedProvisionModule::class,
    DelegateBindingModule::class,
    QualifiedProvisionModule::class,
    MultiBindingsProvisionModule::class,
    AndroidSupportInjectionModule::class,

    // Activities
    HomeActivity.Builder::class
  ]
)
interface AppComponent : AndroidInjector<App> {

  fun inject(memberInjectionTarget: MemberInjectionTarget)

  fun simpleSubcomponentFactory(): SimpleSubcomponent.Factory

  @Component.Factory
  interface Factory {
    fun build(@BindsInstance application: Application): AppComponent
  }
}

