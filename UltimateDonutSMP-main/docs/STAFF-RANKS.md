# Staff ranks & chat/tab tags

Chat and tab already use LuckPerms (or Vault) prefixes via PlaceholderAPI / the built-in resolver.

Format in chat: **`[RankTag] username message`**

## Recommended ranks (highest weight last)

| Rank | Suggested LuckPerms weight | Suggested prefix |
|------|----------------------------|------------------|
| Helper | 10 | `&a[Helper] ` |
| Senior Helper | 20 | `&2[SrHelper] ` |
| Moderator | 30 | `&9[Mod] ` |
| Senior Moderator | 40 | `&3[SrMod] ` |
| Administrator | 50 | `&c[Admin] ` |
| Senior Administrator | 60 | `&4[SrAdmin] ` |
| Staff Lead | 70 | `&6[StaffLead] ` |
| Moderation Lead | 80 | `&5[ModLead] ` |
| Developer | 90 | `&d[Dev] ` |
| Founder | 100 | `&e[Founder] ` |

## Example LuckPerms commands

```bash
/lp creategroup helper
/lp group helper meta setprefix 10 "&a[Helper] "
/lp group helper parent add default

/lp creategroup seniorhelper
/lp group seniorhelper meta setprefix 20 "&2[SrHelper] "
/lp group seniorhelper parent add helper

# ...repeat for each rank...

/lp user <name> parent set founder
```

Tab list uses the same prefix source (`%luckperms_prefix%` / Vault). No extra plugin code is required once prefixes are set.

## Spawn protection

Everyone in the spawn cuboid cannot build, break, damage, interact with blocks, or take damage, **regardless of rank**.

Only players with `ultimatedonutsmp.spawn.bypass` (included under `ultimatedonutsmp.admin` by default for ops) can bypass.

Grant narrowly if needed:

```bash
/lp user <founder> permission set ultimatedonutsmp.spawn.bypass true
```
