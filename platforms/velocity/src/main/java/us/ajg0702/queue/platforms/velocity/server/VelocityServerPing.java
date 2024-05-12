package us.ajg0702.queue.platforms.velocity.server;

import com.velocitypowered.api.proxy.server.RegisteredServer;
import com.velocitypowered.api.proxy.server.ServerPing;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import us.ajg0702.queue.api.server.AdaptedServerPing;

public class VelocityServerPing implements AdaptedServerPing {

    private final ServerPing handle;
    private final RegisteredServer handle2;
    private final long sent;
    public VelocityServerPing(ServerPing handle, long sent, RegisteredServer handle2) {
        this.handle = handle;
        this.sent = sent;
        this.handle2 = handle2;
    }

    @Override
    public Component getDescriptionComponent() {
        return handle.getDescriptionComponent();
    }

    @Override
    public String getPlainDescription() {
        return PlainTextComponentSerializer.plainText().serialize(handle.getDescriptionComponent());
    }

    int add = 0;

    @Override
    public int getPlayerCount() {
        return handle2.getPlayersConnected().size();
    }

    @Override
    public int getMaxPlayers() {
        return handle.getPlayers().map(ServerPing.Players::getMax).orElse(0);
    }

    @Override
    public void addPlayer() {
        add++;
    }

    @Override
    public long getFetchedTime() {
        return sent;
    }

    @Override
    public ServerPing getHandle() {
        return handle;
    }
}
