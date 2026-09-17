import SwiftUI
import Shared

@main
struct iOSApp: App {
    init() {

        AppModule_iosKt.doInitKoinIOS()

    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}