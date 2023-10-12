package app.revanced.patches.music.player.newplayerlayout

import app.revanced.patcher.data.ResourceContext
import app.revanced.patcher.patch.ResourcePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patches.music.utils.playerlayouthook.PlayerLayoutHookPatch
import app.revanced.patches.music.utils.settings.SettingsPatch
import app.revanced.util.enum.CategoryType

@Patch(
    name = "Enable new player layout",
    description = "Enable new player layouts.",
    [
        PlayerLayoutHookPatch::class,
        SettingsPatch::class
    ],
    compatiblePackages = [
        CompatiblePackage(
            "com.google.android.apps.youtube.music",
            [
                "6.15.52",
                "6.20.51",
                "6.21.51",
                "6.22.51"
            ]
        )
    ]
)
@Suppress("unused")
object NewPlayerLayoutPatch : ResourcePatch() {
    override fun execute(context: ResourceContext) {

        SettingsPatch.addMusicPreference(
            CategoryType.PLAYER,
            "revanced_enable_new_player_layout",
            "true"
        )

    }
}