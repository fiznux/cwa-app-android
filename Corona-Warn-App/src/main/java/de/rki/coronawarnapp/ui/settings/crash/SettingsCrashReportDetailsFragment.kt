package de.rki.coronawarnapp.ui.settings.crash

import android.os.Bundle
import androidx.fragment.app.Fragment
import de.rki.coronawarnapp.R
import de.rki.coronawarnapp.databinding.FragmentSettingsCrashReportDetailsBinding
import de.rki.coronawarnapp.util.di.AutoInject
import de.rki.coronawarnapp.util.ui.viewBindingLazy
import de.rki.coronawarnapp.util.viewmodel.CWAViewModelFactoryProvider
import de.rki.coronawarnapp.util.viewmodel.cwaViewModels
import javax.inject.Inject

class SettingsCrashReportDetailsFragment :
    Fragment(R.layout.fragment_settings_crash_report_details), AutoInject {

    companion object {
        private val TAG = SettingsCrashReportDetailsFragment::class.java.simpleName
    }

    @Inject lateinit var viewModelFactory: CWAViewModelFactoryProvider.Factory
    private val vm: SettingsCrashReportViewModel by cwaViewModels(
        ownerProducer = { requireActivity().viewModelStore },
        factoryProducer = { viewModelFactory }
    )
    private val fragmentSettingsCrashReportDetailsBinding: FragmentSettingsCrashReportDetailsBinding by viewBindingLazy()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm.selectedCrashReport?.let {
            fragmentSettingsCrashReportDetailsBinding.textViewCrashReportDetails.text =
                "Selected crash report ${it.id}"
        } ?: run {
            fragmentSettingsCrashReportDetailsBinding.textViewCrashReportDetails.text =
                "No crash report was selected"
        }
    }
}
