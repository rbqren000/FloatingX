package com.petterp.floatingx.impl.provider.scope

import android.app.Application
import android.view.View
import android.view.ViewGroup
import com.petterp.floatingx.assist.helper.FxScopeHelper
import com.petterp.floatingx.impl.provider.FxBasisControlImpl
import com.petterp.floatingx.listener.control.IFxScopeControl

/** Fx普通View控制器 */
class FxScopeControl(helper: FxScopeHelper) :
    FxBasisControlImpl<FxScopeHelper, FxScopePlatFromProvider>(helper), IFxScopeControl {

    override fun createPlatformProvider(f: FxScopeHelper) = FxScopePlatFromProvider(f)

    fun setContainerGroup(viewGroup: ViewGroup) {
        platformProvider.setContainerGroup(viewGroup)
    }

    override fun updateView(view: View) {
        check(view.context !is Application) {
            "view = Application,Scope floating windows cannot use application-level views!"
        }
        super.updateView(view)
    }
}
