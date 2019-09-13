CREATE PROCEDURE FizetesModLetrehozasa
(
@Mod nvarchar(20),
@Hatarido int
)
AS
insert into FizetesMod
values(@Mod,@Hatarido)
select scope_identity() as UjId
